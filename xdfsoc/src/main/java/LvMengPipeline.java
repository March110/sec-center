import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class LvMengPipeline implements Pipeline{

	 public LvMengPipeline() {}

	 public void process(ResultItems resultitems, Task task) {
	        Map<String, Object> mapResults = resultitems.getAll();
	        Iterator<Entry<String, Object>> iter = mapResults.entrySet().iterator();
	        Map.Entry<String, Object> entry;
	        // 输出到控制台
	        while (iter.hasNext()) {
	            entry = iter.next();
	            System.out.println(entry.getKey() + "：" + entry.getValue());
	        }
	        // 持久化
	        File fout = new File("D:\\out.txt");  
	        try {
				FileOutputStream fos = new FileOutputStream(fout,true);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
				try {
					bw.write(mapResults.get("Title")+"-->"+mapResults.get("Content"));
					bw.newLine();
					bw.flush();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
//	        News news = new News();
//	        if (!mapResults.get("Title").equals("")) {
//	            news.setTitle((String) mapResults.get("Title"));
//	            news.setContent((String) mapResults.get("Content"));
//	        }
	        
	        
	     //   OutputStreamWriter pw = new OutputStreamWriter();
	       // System.out.println(news.getTitle()+" -> "+news.getContent());
//	        try {
//	            InputStream is = Resources.getResourceAsStream("conf.xml");
//	            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(new InputStreamReader(is));
//	            SqlSession session = sessionFactory.openSession();
//	            session.insert("add", news);
//	            session.commit();
//	            session.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
	    }

}
