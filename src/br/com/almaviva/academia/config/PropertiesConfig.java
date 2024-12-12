package br.com.almaviva.academia.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesConfig {
    private static final Logger logger = Logger.getLogger(PropertiesConfig.class.getName());
	private static Properties properties = new Properties();

	static void carregarConfigs() {
		try (FileInputStream arquivoProps = new FileInputStream("resources/config.properties")) {
			properties.load(arquivoProps);
		} catch (IOException e) {
			logger.severe("Erro ao carregar config.properties: " + e.getMessage());
		}
	}
	
	public static String getSenhaAdmin(String senha) {
		return properties.getProperty(senha);
	}
	
	public static String getAlmavivaPass(String arquivoGymPass) {
		return properties.getProperty(arquivoGymPass);
	}

	public static String getAcademias(String arquivoAcademias) {
		return properties.getProperty(arquivoAcademias);
	}
	
	public static String getAcademiaPlano(String arquivoAcademiaPlano) {
		return properties.getProperty(arquivoAcademiaPlano);
	}
}