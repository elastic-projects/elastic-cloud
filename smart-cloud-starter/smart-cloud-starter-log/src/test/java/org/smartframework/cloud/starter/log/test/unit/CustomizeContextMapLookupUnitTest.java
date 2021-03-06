package org.smartframework.cloud.starter.log.test.unit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.smartframework.cloud.starter.log.enums.ExtProperty;
import org.smartframework.cloud.starter.log.log4j2.plugin.CustomizeContextMapLookup;

class CustomizeContextMapLookupUnitTest {

    @Test
    void testReadAppName() {
        CustomizeContextMapLookup customizeContextMapLookup = new CustomizeContextMapLookup();
        Assertions.assertThat(customizeContextMapLookup.lookup(ExtProperty.APP_NAME.getName())).isEqualTo("smart-cloud-starter-log");
    }

}