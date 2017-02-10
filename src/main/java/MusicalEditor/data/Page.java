package MusicalEditor.data;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikalenovo on 09.02.2017.
 */
public class Page {
    List<Tact> tacts=new ArrayList<>();

    public List<Tact> getTacts() {
        return tacts;
    }

    public void setTacts(List<Tact> tacts) {
        this.tacts = tacts;
    }

    public static Page parse(File file) throws Exception{
        FileInputStream fis = new FileInputStream(file);
        ObjectMapper mapper = new ObjectMapper();

        JsonFactory f = new JsonFactory();
        JsonParser jp = f.createParser(fis);
        jp.nextToken();

        int size = 0;
        Page page = mapper.readValue(jp, Page.class);
        return page;
    }

    @Override
    public String toString() {
        return "Page{" +
                "tacts=" + tacts +
                "\n}\n";
    }

    public void paint(Graphics g) {
        int y=0;
        for(Tact tact:tacts){
            tact.paint(g,y);
            y+=200;
        }
    }
}
