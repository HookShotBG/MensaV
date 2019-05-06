package MensaVoter;

import java.io.StringWriter;
import java.util.HashMap;

import MensaVoter.Main;
import freemarker.template.*;

public class TemplatingEngine {
	static private Configuration cfg = new Configuration(new Version("2.3.28"));

	public TemplatingEngine(String path) {
		cfg.setClassForTemplateLoading(Main.class, path);
		cfg.setDefaultEncoding("UTF-8");
	}
	
	public String renderTemplate(String file, HashMap<String, Object> data) {
		try {
			Template template = cfg.getTemplate(file);
			StringWriter output = new StringWriter();
			template.process(data, output);
			return output.toString();
		} catch (Exception e) {
			System.out.println(e);
			return "Error: "+e;
		}
	}
}
