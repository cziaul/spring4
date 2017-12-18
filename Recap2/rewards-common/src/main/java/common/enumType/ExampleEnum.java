package common.enumType;

public enum ExampleEnum {

    DB_ERROR( PropertiesUtil.getProperty("DB_ERRROR_CODE"), PropertiesUtil.getProperty("DB_ERROR")),
    APP_ERROR(PropertiesUtil.getProperty("APPLICATION_ERROR_CODE"), PropertiesUtil.getProperty("APPLICATION_ERROR")),
    ERROR_FOUND(PropertiesUtil.getProperty("ERROR_FOUND_CODE"), PropertiesUtil.getProperty("ERROR_FOUND"));


    private final String errorCode;
    private final String errorDesc;



    private ExampleEnum(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public static String getError(String errorCode)
    { 
        System.out.println("errorCode in Enum"+errorCode);
        System.out.println(java.util.Arrays.asList(ExampleEnum.values()));
        for (ExampleEnum errorEnum : ExampleEnum.values()) {
            System.out.println(errorEnum.errorCode);
            System.out.println(errorEnum.errorDesc);
        if ((errorEnum.errorCode).equals(errorCode)) {
            return errorEnum.getErrorDesc();
        }
        }
        return ERROR_FOUND.getErrorDesc();

    }
}