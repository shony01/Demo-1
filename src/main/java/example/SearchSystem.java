package example;

import java.util.*;

/**
 * @author wangzhuohui
 * @description jiekou
 * @create 2018-06-19 14:41
 */
public class SearchSystem
{
    /**
     * 搜索资源库
     */
    private Map<String, DataInfo> searchMap = new HashMap<String, DataInfo>();

    /**
     * VIP搜索资源库
     */
    private Map<String, List<SearchData>> vipSearchMap = new HashMap<String, List<SearchData>>();

    /**
     * 访问量搜索资源库
     */
    private Map<String, List<SearchData>> visitSearchMap = new HashMap<String, List<SearchData>>();

    /**
     * 根据访问量排序
     */
    Comparator<SearchData> comparator = new Comparator<SearchData>()
    {
        public int compare(SearchData o1, SearchData o2)
        {
            DataInfo di1 = searchMap.get(o1.getName());
            DataInfo di2 = searchMap.get(o2.getName());
            return di1.getVisitNum() - di2.getVisitNum();
        }
    };

    /**
     * 初始化系统。
     *
     * @return String 成功后，返回Constants.E000
     */
    public String init()
    {
        return Constants.E000;
    }

    /**
     * 索引库刷新。
     * 定时任务通过索引库刷新接口定时刷新索引库数据，已供搜索引擎查询。
     *
     * @param dataInfos 数据集合
     * @return String 成功后，返回Constants.E000
     */
    public String refresh(List<DataInfo> dataInfos)
    {
        for (DataInfo dataInfo : dataInfos)
        {
            searchMap.put(dataInfo.getName(), dataInfo);

            if (dataInfo.isVip())
            {
                addRefresh(dataInfo, vipSearchMap);
            }
            else
            {
                addRefresh(dataInfo, visitSearchMap);
            }
        }

        return Constants.E000;
    }

    /**
     * 分类刷新方法
     * @author wangzhuohui
     * @since 2018/6/19 19:10
     * @param dataInfo
     * @param searchMap
     * @return 
     * 
     */
    private void addRefresh(DataInfo dataInfo, Map<String, List<SearchData>> searchMap)
    {
        String[] keys = dataInfo.getContent().split("[^A-Za-z]");
        SearchData searchData = null;
        List<SearchData> searchDataList = null;
        for (String key : keys)
        {
            if (null != key && key.trim().length() > 0)
            {
                searchData = new SearchData();
                searchData.setName(dataInfo.getName());
                if (null != searchMap.get(key))
                {
                    searchDataList = searchMap.get(key);
                    for(SearchData searchData1 : searchDataList)
                    {
                        if(dataInfo.getName().equals(searchData1.getName()))
                        {
                            searchData1.getIndexs().addAll(getIndexsOfString(dataInfo.getContent(), key));
                        }
                    }
                    //searchDataList.add(searchData);
                    //searchMap.put(key, searchDataList);
                }
                else
                {
                    searchData.setIndexs(getIndexsOfString(dataInfo.getContent(), key));
                    searchDataList = new LinkedList<SearchData>();
                    searchDataList.add(searchData);
                    searchMap.put(key, searchDataList);
                }
            }
        }
    }

    /**
     * 从content 中获取关键字的所有索引
     * @author wangzhuohui
     * @since 2018/6/19 19:12
     * @param content
     * @param key
     * @return 
     * 
     */
    private Set<Integer> getIndexsOfString(String content, String key)
    {
        Set<Integer> indexs = new HashSet<Integer>();
        int index = content.indexOf(key);
        while (index != -1)
        {
            indexs.add(index);
            index = content.indexOf(key, index + key.length());
        }

        return indexs;
    }

    /**
     * 搜索。
     * 用户通过该搜索接口输入关键字（或关键字组合）进行搜索，返回分页结果。
     *
     * @param keyword 关键字
     * @param start   分页起始索引
     * @param limit   分页最大个数
     * @return List<SearchData> 分页搜索结果
     * @throws SysException 系统异常
     */
    public List<SearchData> search(String keyword, int start, int limit)
        throws SysException
    {
        List<SearchData> searchResult = new ArrayList<SearchData>();

        if (null == keyword || (keyword.contains("&") && keyword.contains("|")))
        {
            return searchResult;
        }
        if (keyword.contains("&"))
        {
            String[] keys = keyword.split("&");
            searchResult = searchDataByPage(true, keys, start, limit);
        }
        else if (keyword.contains("|"))
        {
            String[] keys = keyword.split("|");
            searchResult = searchDataByPage(false, keys, start, limit);
        }
        else
        {
            String[] keys = {keyword};
            searchResult = searchDataByPage(false, keys, start, limit);
        }

        return searchResult;
    }

    /**
     * 相似推荐。
     * 1、用户搜索时，同时会调用该接口返回搜索库中前匹配的推荐关键字列表。
     * 2、推荐个数最大为10个。
     *
     * @param keyword 关键字
     * @return List<String> 推荐的关键字集合
     * @throws SysException 系统异常
     */
    public List<String> recommend(String keyword)
        throws SysException
    {
        //TODO 请自行完成

        return null;
    }

    /**
     * 搜索排行榜。
     * 提供查询TOP 10搜索记录的接口。
     *
     * @return List<String> 关键字集合
     */
    public List<String> top()
    {
        //TODO 请自行完成

        return null;
    }
    
    /**
     * 分页搜索结果集
     * @author wangzhuohui
     * @since 2018/6/19 19:15
     * @param merge
     * @param keys
     * @param start
     * @param limit
     * @return 
     * 
     */
    private List<SearchData> searchDataByPage(boolean merge, String[] keys, int start, int limit)
    {
        List<SearchData> searchResult = new ArrayList<SearchData>();
        searchResult = searchData(false, keys, vipSearchMap);
        int size = searchResult.size();
        if (size < (start + limit))
        {
            List<SearchData> reusltVisit = searchData(merge, keys, visitSearchMap);
            searchResult.addAll(reusltVisit);
        }

        int totalSize = searchResult.size();
        if (totalSize < (start + limit))
        {
            searchResult = searchResult.subList(start, totalSize);
        }
        else
        {
            searchResult = searchResult.subList(start, (start + limit));
        }
        return searchResult;
    }
    
    /**
     * 搜索结果集
     * @author wangzhuohui
     * @since 2018/6/19 19:13
     * @param mergeFlag
     * @param keys
     * @param searchMap
     * @return 
     * 
     */
    private List<SearchData> searchData(boolean mergeFlag, String[] keys, Map<String, List<SearchData>> searchMap)
    {
        List<SearchData> result = new ArrayList<SearchData>();

        if (null == keys && keys.length == 0)
        {
            return result;
        }

        List<String> nameList = new ArrayList<String>();
        Map<String, Set<Integer>> mapIndexs = new HashMap<String, Set<Integer>>();
        List<String> searchNameList = null;
        for (String key : keys)
        {
            List<SearchData> searchDataList = null;
            searchNameList = new ArrayList<String>();
            if (null != key)
            {
                searchDataList = searchMap.get(key);
                if (null != searchDataList && searchDataList.size() > 0)
                {
                    Set<Integer> setIndex = null;
                    for (SearchData searchData : searchDataList)
                    {
                        searchNameList.add(searchData.getName());
                        if (null != mapIndexs.get(searchData.getName()))
                        {
                            setIndex = mapIndexs.get(searchData.getName());
                        }
                        else
                        {
                            setIndex = new HashSet<Integer>();
                        }
                        setIndex.addAll(searchData.getIndexs());
                        mapIndexs.put(searchData.getName(), setIndex);
                    }

                    // &
                    if (mergeFlag)
                    {
                        if (nameList.size() != 0)
                        {
                            nameList.retainAll(searchNameList);
                        }
                        else
                        {
                            nameList.addAll(searchNameList);
                        }
                    }
                    else //|
                    {
                        nameList.removeAll(searchNameList);
                        nameList.addAll(searchNameList);
                    }

                    searchNameList.clear();
                    searchDataList.clear();
                }
            }
        }
        SearchData searchData = null;
        for (String name : nameList)
        {
            searchData = new SearchData();
            searchData.setName(name);
            searchData.setIndexs(mapIndexs.get(name));
            result.add(searchData);
        }
        Collections.sort(result, comparator);

        return result;
    }
}
