package WHJ.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002, "没有选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "没有登录"),
    SYS_ERROR(2004, "服务器冒烟了，请稍后再试试！"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在了，要不要换个试试？"),
    CONTENT_IS_EMPTY(2007, "回复内容不能为空！");

    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
