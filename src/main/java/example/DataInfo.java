package example;

/**
 * @author wangzhuohui
 * @description ces
 * @create 2018-06-19 14:38
 */
public class DataInfo
{
    /**
     * 正文名
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否VIP
     */
    private boolean vip;

    /**
     * 访问量
     */
    private int visitNum;

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
     * 获取内容
     *
     * @return 内容
     */
    public String getContent()
    {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content)
    {
        this.content = content;
    }

    /**
     * 是否VIP
     *
     * @return 是否VIP
     */
    public boolean isVip()
    {
        return vip;
    }

    /**
     * 设置VIP标识
     *
     * @param vip VIP标识
     */
    public void setVip(boolean vip)
    {
        this.vip = vip;
    }

    /**
     * 获取访问量
     *
     * @return 访问量
     */
    public int getVisitNum()
    {
        return visitNum;
    }

    /**
     * 设置访问量
     *
     * @param visitNum 访问量
     */
    public void setVisitNum(int visitNum)
    {
        this.visitNum = visitNum;
    }
}
