package example;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author wangzhuohui
 * @description jieguo
 * @create 2018-06-19 14:40
 */
public class SearchData
{
    /**
     * 正文名
     */
    private String name;

    /**
     * 关键字出现在正文的位置起始索引集合
     */
    private Set<Integer> indexs = new TreeSet<Integer>();

    /**
     * 获取正文名
     *
     * @return 正文名
     */
    public String getName()
    {
        return name;
    }

    /**
     * 设置正文名
     *
     * @param name 正文名
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * 获取起始索引
     *
     * @return 起始索引
     */
    public Set<Integer> getIndexs()
    {
        return indexs;
    }

    /**
     * 设置起始索引
     *
     * @param indexs 起始索引
     */
    public void setIndexs(Set<Integer> indexs)
    {
        this.indexs = indexs;
    }
}
