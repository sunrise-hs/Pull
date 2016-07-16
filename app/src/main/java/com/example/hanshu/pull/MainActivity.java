package com.example.hanshu.pull;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<XmlBean> list=null;
    XmlBean b;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            AssetManager am = this.getAssets();
            InputStream in = am.open("sms.xml");
            lv=(ListView)findViewById(R.id.listView);
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(in, "utf-8");
            int type = parser.getEventType();

            while (type != XmlPullParser.END_DOCUMENT) {
                if (type == XmlPullParser.START_TAG) {
                    if ("smss".equals(parser.getName())) {
                        list = new ArrayList<XmlBean>();
                    } else if ("sms".equals(parser.getName())) {
                        b = new XmlBean();
                        String idStr = parser.getAttributeValue(0);
                        System.out.println("sms");
                    } else if ("body".equals(parser.getName())) {
                        String str = parser.nextText();
                        b.setBody(str);
                    } else if ("address".equals(parser.getName())) {
                        String str = parser.nextText();
                        b.setAddress(str);
                    } else if ("date".equals(parser.getName())) {
                        String str = parser.nextText();
                        Long l = Long.parseLong(str);
                        b.setData(l);
                    } else if ("type".equals(parser.getName())) {
                        String str = parser.nextText();
                        int i = Integer.parseInt(str);
                        b.setType(i);
                    }
                }
                if(type==XmlPullParser.END_TAG){
                    if ("sms".equals(parser.getName())) {
                        list.add(b);
                        lv.setAdapter(new MyAdapter());
                    }
                }
                type=parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class MyAdapter extends BaseAdapter {
        public int getCount() {
            return list.size();
        }
        public Object getItem(int i) {
            return null;
        }
        public long getItemId(int i) {
            return 0;
        }
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView tv=new TextView(MainActivity.this);
            tv.setText(list.get(i).toString());
            return tv;
        }
    }
}
