package org.smartframework.cloud.code.generate.util;

import java.io.StringWriter;
import java.io.Writer;

import org.smartframework.cloud.code.generate.config.Config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * FreeMarker 工具类
 *
 * @author liyulin
 * @date 2019-07-13
 */
@UtilityClass
@Slf4j
public class FreeMarkerUtil {

	private static Configuration freemarkerCfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
	static {
		freemarkerCfg.setClassForTemplateLoading(FreeMarkerUtil.class, Config.TEMPLATE_PATH);
	}

	/**
	 * 根据模板名及模板参数信息，获取渲染后的字符串
	 * 
	 * @param data
	 * @param templateName
	 * @return
	 */
	public static String freeMarkerRender(Object data, String templateName) {
		try (Writer out = new StringWriter();) {
			Template template = freemarkerCfg.getTemplate(templateName, Config.DEFAULT_ENCODING);
			template.process(data, out);
			out.flush();
			return out.toString();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

}