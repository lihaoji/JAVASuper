package com.lhj.sp;

/**
 * @author lihaoji
 * @create 2019-12-28 21:11
 */
public enum CountryEnum {

    ONE(1,"齐国"),TWO(2,"赵国"),THREE(3,"燕国"),FOUR(4,"魏国"),FIVE(5,"韩国"),SIX(6,"楚国");

    private Integer code;
    private String message;




    public static CountryEnum getContry(Integer index){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            if (value.getCode()==index){
                return value;
            }
        }
        return null;
    }

    CountryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    CountryEnum() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
