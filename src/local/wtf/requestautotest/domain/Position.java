package local.wtf.requestautotest.domain;
/**
 * 
 * @author wangtengfei3
 * @since 2016年9月22日 上午 10:47
 * */
public enum Position {
	
	/*http headers*/
	HEADER("0","http headers"),
	/*http url*/
	URL("1","http url"),  	
	/*http body*/
	BODY("2","http body");
	
	/**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;

    Position(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据位置码获取位置信息
     * @param code
     * @return
     */
    public static Position codeOf(String code) {
        for (Position val : Position.values()) {
            if (val.code.equals(code)) {
                return val;
            }
        }
        throw new IllegalArgumentException("PositionEnum.codeOf(" + code + ") not found!");
    }
}
