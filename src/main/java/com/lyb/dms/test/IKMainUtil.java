package com.lyb.dms.test;
import java.io.IOException;  
import java.io.StringReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.collections.MapUtils;  
import org.apache.commons.lang3.tuple.MutablePair;  
import org.apache.commons.lang3.tuple.Pair;
import org.wltea.analyzer.core.IKSegmenter;  
import org.wltea.analyzer.core.Lexeme;  

public class IKMainUtil {  
  
    /** 
     * @param args 
     * @throws IOException 
     */  
    public static void main(String[] args) throws IOException { 
    
        
    	 String str1 = "音乐 听歌 唱歌 唱K 歌唱 MP3 MP4 耳机 hifi 音响"
		 	+"乐器 打鼓 吉他 钢琴 架子鼓 萨克风 口琴 口风琴 笛 箫 贝斯 乌克丽丽"
	    	+"运动 篮球 跑步 散步 乒乓球 踢球 足球 排球 橄榄球 高尔夫球 棒球 体操 太极 拳击 武术 跆拳道 柔道 自行车 单车 健身"
	    	+"舞蹈 街舞 霹雳舞 芭蕾舞 锁舞 breaking locking poping 爵士舞 hiphop 嘻哈 jazz 雷鬼 跳舞 "
	    	+"阅读 读书 看书 "
	    	+"娱乐 游戏 打机 LOL 吃鸡 绝地求生 手游 王者荣耀 英雄联盟 手机 桌游 玩具 模型 高达 电脑 xbox ps3 ps4 steam 守望先锋 战网 对战平台"
	    	+"烹饪 煮东西 做菜 煮菜 做饭 美食 菜谱"
	    	+"摄影 照相 单反 胶卷 微单 影像 影相 录像 人像 风景"
	    	+"电影 看电影 电视 美剧 韩剧 日剧 动漫 日漫 日剧 港剧 电影院"
	    	+"其他 睡觉 编程 打代码 学习 other  艺术 画画 收藏 古董 手表 旅游 爬山 郊游 出游 驾驶 开车";
    	 
    	 
    	 
    	 //String str2 = "唱K 吉他";   //0.13736056394868904
         //String str2 = "吉他 唱K"; //0.13736056394868904
         //String str2 = "歌唱 ps4"; //0.11215443081840884
         String str2 = "歌唱";
         
/*         Double d =compareTwoText(str1,str2);
         
         System.out.println(d);*/
         
         
         Map<Integer,String> studentHobby =new HashMap<Integer,String>();
         studentHobby.put( 1000, " 运动 篮球 唱K 吉他");
         studentHobby.put(2111, "煮东西  篮球 做菜 煮菜");
         studentHobby.put( 3222, "听歌  绝地求生 唱歌 唱K 歌唱");
         studentHobby.put( 4000, "吃鸡  运动 绝地求生 手游");
         studentHobby.put( 5115, "吃鸡 音乐   绝地求生 手机 桌游 玩具 ");
         studentHobby.put(6333, "音乐 乐器  运动 打鼓 吉他 ");
         studentHobby.put(711, "运动 篮球  绝地求生");
         studentHobby.put( 8111, "运动 篮球 跑步 散步  打鼓 吉他");
         
         sortStudent(studentHobby);
    }  
  
    public static Map<String, Integer> getTF(String str) throws IOException {  
        Map<String, Integer> map = new HashMap<String, Integer>();  
        IKSegmenter ikSegmenter = new IKSegmenter(new StringReader(str), true);  
        Lexeme lexeme = null;  
        while ((lexeme = ikSegmenter.next()) != null) {  
            String key = lexeme.getLexemeText();  
            Integer count = map.get(key);  
            if (null == count) {  
                count = 1;  
            } else {  
                count = count + 1;  
            }  
            map.put(key, count);  
        }  
        return map;  
    }  
  
    public static Double caclIDF(Map<String, MutablePair<Integer, Integer>> tf) {  
        Double d = 0.0;  
        if (MapUtils.isEmpty(tf)) {  
            return d;  
        }  
        Double denominator = 0.0;  
        Double sqdoc1 = 0.0;  
        Double sqdoc2 = 0.0;  
        Pair<Integer, Integer> count = null;  
        for (String key : tf.keySet()) {  
            count = tf.get(key);  
            denominator += count.getLeft() * count.getRight();  
            sqdoc1 += count.getLeft() * count.getLeft();  
            sqdoc2 += count.getRight() * count.getRight();  
        }  
        d = denominator / (Math.sqrt(sqdoc1) * Math.sqrt(sqdoc2));  
        return d;  
    }
    
    public static Map<String,Double> sortStudent(Map<Integer,String> studentHobby) throws IOException{
    	Map<Integer,String> studentHobby_copy = studentHobby; 
        
        
        
        HashMap<String,Double> map = new HashMap<String,Double>();  

        

    	Iterator<Entry<Integer, String>> iterator = studentHobby.entrySet().iterator();
    	while(iterator.hasNext()){
    		Map.Entry entry = (Map.Entry) iterator.next();
    		Integer key = (Integer) entry.getKey();
    		String val = (String) entry.getValue();
    		
        	Iterator<Entry<Integer, String>> iterator_copy = studentHobby_copy.entrySet().iterator();
        	while(iterator_copy.hasNext()){
        		
        		Map.Entry entry_copy = (Map.Entry) iterator_copy.next();
        		Integer key_copy = (Integer) entry_copy.getKey();
        		String val_copy = (String) entry_copy.getValue();
        		if(key!=key_copy){
        		
        		//System.out.println(key+"-"+key_copy+":"+compareTwoText(val,val_copy));
        		
        		map.put(key+"-"+key_copy, compareTwoText(val,val_copy));
        		
        		}
                
        		
        	}
        	
/*        	
        	while(iterator_copy.hasNext()){
        		Map.Entry entry_copy = (Map.Entry) iterator_copy.next();
        		
        		Integer key_copy = (Integer) entry_copy.getKey();
        		if(key!=key_copy){
        			String val_copy = (String) entry_copy.getValue();
        			System.out.println(key+"---"+key_copy+":"+compareTwoText(val,val_copy));
        		}
        		
        		
        		
        		
        	}*/
        	iterator.remove();
        	
        	
        	
        	 
    	}
    	
    	ValueComparator bvc =  new ValueComparator(map);  
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);  

  
        //System.out.println("unsorted map: "+map);  
  
        sorted_map.putAll(map);  
  
        //System.out.println("results: "+sorted_map);  
    	
    	
    	return sorted_map;
    }
    
    
    
    
    
    public static Double compareTwoText(String str1,String str2) throws IOException{
        Map<String, Integer> tf1 = getTF(str1);  
        Map<String, Integer> tf2 = getTF(str2);  
        Map<String, MutablePair<Integer, Integer>> tfs = new HashMap<String, MutablePair<Integer, Integer>>();  
        for (String key : tf1.keySet()) {  
            MutablePair<Integer, Integer> pair = new MutablePair<Integer, Integer>(tf1.get(key), 0);  
            tfs.put(key, pair);  
        }  
        for (String key : tf2.keySet()) {  
            MutablePair<Integer, Integer> pair = tfs.get(key);  
            if (null == pair) {  
                pair = new MutablePair<Integer, Integer>(0, tf2.get(key));  
            } else {  
                pair.setRight(tf2.get(key));  
            }  
        }  
        Double d = caclIDF(tfs); 
        if(d.isNaN()){
        	return 0.0;
        }else{
        	return d; 
        }
        
    }
}  

class ValueComparator implements Comparator<String> {  
	  
    Map<String, Double> base;  
    //这里需要将要比较的map集合传进来
    public ValueComparator(Map<String, Double> base) {  
        this.base = base;  
    }  
  
    // Note: this comparator imposes orderings that are inconsistent with equals.    
    //比较的时候，传入的两个参数应该是map的两个key，根据上面传入的要比较的集合base，可以获取到key对应的value，然后按照value进行比较   
    public int compare(String a, String b) {
/*    	if(a.charAt(0)>=b.charAt(0)){
    		return 1;
    	}else{
    		return -1;
    	}*/
    	
    	
/*    	if(a.charAt(0)>=b.charAt(0)){


    		
    		if(a.charAt(2)>=b.charAt(2)){
        		return 1;
        	}else{
        		return -1;
        	}
    	}else{
    		return -1;
    	}*/
    	
    	
    	
    	//return a.charAt(0)>=b.charAt(0)?a.charAt(2)>=b.charAt(2)?  1     :-1:-1;
    	
    /*	if(a.charAt(2)>=b.charAt(2)){
    		return 1;
    	}else{
    		return -1;
    	}*/
    	
    	
    	
       if (base.get(a) >= base.get(b)) {  
            return -1;  
        } else {  
            return 1;  
        }
    	
    	
/*    	if (base.get(b) >= base.get(a)) {  
            return 1;  
        } else {  
            return -1;  
        }*/
    }  
}  