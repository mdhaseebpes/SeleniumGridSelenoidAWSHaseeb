package com.magneto.constants;

public interface FileLocations {

    String APP_PATH = System.getProperty("user.dir");
    String CONFIG_PATH = APP_PATH + "/src/test/java/resources/config/config.properties";

    String QA_CONFIG_PATH = APP_PATH + "/src/test/java/resources/config/qaConfig.properties";

    String DEV_CONFIG_PATH = APP_PATH + "/src/test/java/resources/config/devConfig.properties";

    String STAGE_CONFIG_PATH = APP_PATH + "/src/test/java/resources/config/stageConfig.properties";
    String TEST_DATA_PATH = APP_PATH+"/src/test/java/resources/data/testData.properties";

}
