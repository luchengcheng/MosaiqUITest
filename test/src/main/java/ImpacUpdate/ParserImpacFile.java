package ImpacUpdate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ParserImpacFile {

    public HashMap<String, Properties> sections = new HashMap<String, Properties>();
    private transient String defaultName = "default";
    private transient String sectionName;
    private transient Properties property;
    private Properties parentObj;

    public void ParseIni(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            read(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void read(BufferedReader reader) throws IOException {
        String line;
        sectionName = this.defaultName;
        property = new Properties();
        sections.put(sectionName, property);

        while ((line = reader.readLine()) != null) {
            parseLine(line);
        }
    }
    protected void parseLine(String line) {
        line = line.trim();
        if (line.indexOf('#') == 0 || line.indexOf(';') == 0) {
            return;
        }

        if (line.matches("\\[.*\\]")) {
            sectionName = line.replaceFirst("\\[(.*)\\]", "$1").trim();
            property = new Properties();
            if (sectionName.matches(".*:.*")) {
                int pos = sectionName.indexOf(':');
                String child = sectionName.substring(0, pos);
                String parent = sectionName.substring(pos + 1);

                parentObj = this.getSection(parent);
                if (parentObj != null) {
                    property = (Properties) parentObj.clone();
                    sections.put(child, property);
                }
            } else {
                sections.put(sectionName, property);
            }
        } else if (line.matches(".*=.*")) {
            int i = line.indexOf('=');
            String name = line.substring(0, i).trim();
            String value = line.substring(i + 1).trim();

            if (value.indexOf('"') == 0 || value.indexOf('\'') == 0) {
                // 去掉前面符号 " 或 '
                value = value.substring(1, value.length());
                // 去掉后面 " 或 '
                int len = value.length();
                if (value.indexOf('"') == len - 1 || value.indexOf('\'') == len - 1) {
                    value = value.substring(0, len - 1);
                }
            }

            property.setProperty(name, value);
        }
    }

    public String get(String section, String key) {
        if (section.equals(null) || section == "")
            section = this.defaultName;

        Properties property = (Properties) sections.get(section);
        if (property == null) {
            return null;
        }

        String value = property.getProperty(key);
        if (value == null)
            return null;

        return value;
    }

    /**
     * 获取节下所有key
     *
     * @param section
     * @return Properties
     */
    public Properties getSection(String section) {
        if (section.equals(null) || section == "")
            section = this.defaultName;

        Properties property = (Properties) sections.get(section);
        if (property == null) {
            sections.put(section, property);
        }

        return property;
    }
    public void set(String section, String key, String value) {
        if (property == null)
            property = new Properties();

        if (section.equals(null) || section == "")
            section = this.defaultName;

        if (key.equals(null) || key == "") {
            System.out.println("key is null");
            return;
        }

        sections.put(section, property);
        property.setProperty(key, value);
    }

    /**
     * 增加节点
     *
     * @param section
     */
    public void setSection(String section) {
        sections.put(section, property);
    }



}
