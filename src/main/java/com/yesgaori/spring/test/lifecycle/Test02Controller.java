package com.yesgaori.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> movieList(){
		
		List<Map<String, Object>> mapList = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		Map<String, Object> map3 = new HashMap<>();
		Map<String, Object> map4 = new HashMap<>();
		Map<String, Object> map5 = new HashMap<>();
		
		map1.put("rate", 15);
		map1.put("director", "봉준호");
		map1.put("time", 131);
		map1.put("title", "기생충");
		
		mapList.add(map1);

		map2.put("rate", 0);
		map2.put("director", "로베르트 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");
		
		mapList.add(map2);
		
		map3.put("rate", 12);
		map3.put("director", "크리스토퍼놀란");
		map3.put("time", 147);
		map3.put("title", "인셉션");
		
		mapList.add(map3);
		
		map4.put("rate", 19);
		map4.put("director", "윤종빈");
		map4.put("time", 133);
		map4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		
		mapList.add(map4);
		
		
		map5.put("rate", 15);
		map5.put("director", "프란시스 로렌스");
		map5.put("time", 137);
		map5.put("title", "헝거게임");
		
		mapList.add(map5);
		
		return mapList;
		
		
		
	}
	@RequestMapping("/2")
	public List<Post> postList() {
		List<Post> list = new ArrayList<>();
		Post first = new Post("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		list.add(first);
		Post second = new Post("헐 대박", "bada", "오늘 목요일이었어... 금요일인줄");
		list.add(second);
		Post third = new Post("오늘 데이트 한 이야기 해드릴게요.", "dulumary", "....");
		list.add(third);
		return list;
		
	}
	@RequestMapping("/3")
	public ResponseEntity<Post> entityResponse() {
		Post one = new Post("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		ResponseEntity<Post> entity = new ResponseEntity(one, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
}
