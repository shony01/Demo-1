package example;

/**
 * @author wangzhuohui
 * @description yichang
 * @create 2018-06-19 14:42
 */
public class SysException extends Exception
{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 错误信息 */
    private String errorMsg;

    /**
     * 构造函数
     *
     * @param errorMsg 错误信息
     */
    public SysException(String errorMsg)
    {
        super();
        this.errorMsg = errorMsg;
    }

    /**
     * 构造函数
     *
     * @param errorMsg 错误信息
     * @param cause 异常堆栈
     */
    public SysException(String errorMsg, Throwable cause)
    {
        super(cause);
        this.errorMsg = errorMsg;
    }

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    public String getErrorMsg()
    {
        return errorMsg;
    }

    /**
     * 设置错误信息
     *
     * @param errorMsg
     */
    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
}
