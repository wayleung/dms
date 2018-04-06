package com.lyb.dms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyb.dms.domain.Dorm;
import com.lyb.dms.domain.DormExample;
import com.lyb.dms.domain.DormStudent;
import com.lyb.dms.domain.Student;
import com.lyb.dms.domain.DormStudentExample.Criteria;
import com.lyb.dms.serviceImpl.DormServiceImpl;
import com.lyb.dms.serviceImpl.DormStudentServiceImpl;
import com.lyb.dms.serviceImpl.StudentServiceImpl;
import com.lyb.dms.test.IKMainUtil;
import com.lyb.dms.vo.DormStudentVO;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/dms")
public class DormStudentController {

	@Resource
	private DormStudentServiceImpl dormStudentServiceImpl;

	@Resource
	private DormServiceImpl dormServiceImpl;

	@Resource
	private StudentServiceImpl studentServiceImpl;

	@RequestMapping(value = "/insertDormStudent", method = RequestMethod.POST)
	public String insertDormStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentId = request.getParameter("studentId");
		String dormId = request.getParameter("dormId");
		String joinTime = request.getParameter("joinTime");
		String leaveTime = request.getParameter("leaveTime");
		String leaveReason = request.getParameter("leaveReason");
		String createTime = request.getParameter("createTime");
		String remark = request.getParameter("remark");
		DormStudent dormStudent = new DormStudent();

		if (studentId != null && !studentId.equals("")) {
			Integer student_id = Integer.parseInt(studentId);
			dormStudent.setStudentId(student_id);
		}
		if (dormId != null && !dormId.equals("")) {
			Integer dorm_id = Integer.parseInt(dormId);
			dormStudent.setDormId(dorm_id);
		}
		dormStudent.setJoinTime(joinTime);
		dormStudent.setLeaveTime(leaveTime);
		dormStudent.setLeaveReason(leaveReason);
		dormStudent.setCreateTime(createTime);
		dormStudent.setRemark(remark);
		dormStudentServiceImpl.insertDormStudent(dormStudent);
		return null;
	}

	@RequestMapping(value = "/deleteDormStudent", method = RequestMethod.POST)
	public String deleteDormStudent(HttpServletRequest request, HttpServletResponse response) {
		String id_string = request.getParameter("id");
		if (id_string != null) {
			Integer id = Integer.parseInt(id_string);
			dormStudentServiceImpl.deleteDormStudent(id);
			return null;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/updateDormStudent", method = RequestMethod.POST)
	public String updateDormStudent(HttpServletRequest request, HttpServletResponse response) {
		String id_string = request.getParameter("id_update");
		String studentId = request.getParameter("studentId_update");
		String dormId = request.getParameter("dormId_update");
		String joinTime = request.getParameter("joinTime_update");
		String leaveTime = request.getParameter("leaveTime_update");
		String leaveReason = request.getParameter("leaveReason_update");
		String createTime = request.getParameter("createTime_update");
		String remark = request.getParameter("remark");
		DormStudent dormStudent = new DormStudent();

		if (studentId != null && !studentId.equals("")) {
			Integer student_id = Integer.parseInt(studentId);
			dormStudent.setStudentId(student_id);
		}
		if (dormId != null && !dormId.equals("")) {
			Integer dorm_id = Integer.parseInt(dormId);
			dormStudent.setDormId(dorm_id);
		}
		dormStudent.setJoinTime(joinTime);
		dormStudent.setLeaveTime(leaveTime);
		dormStudent.setLeaveReason(leaveReason);
		dormStudent.setCreateTime(createTime);
		dormStudent.setRemark(remark);

		if (id_string != null && !id_string.equals("")) {
			Integer id = Integer.parseInt(id_string);
			dormStudent.setDsId(id);
		}

		dormStudentServiceImpl.updateDormStudent(dormStudent);
		return null;
	}

	@RequestMapping(value = "/queryAllDormStudents", method = RequestMethod.POST)
	public String queryAllDormStudents(HttpServletRequest request, HttpServletResponse response) {
		List<DormStudent> list = dormStudentServiceImpl.queryAllDormStudents();
		Map<String, List<DormStudent>> dataMap = new HashMap<>();
		dataMap.put("dormStudentList", list);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(dataMap);
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/queryDormStudentById", method = RequestMethod.POST)
	public String queryDormStudentById(HttpServletRequest request, HttpServletResponse response) {
		String id_string = request.getParameter("id");
		if (id_string != null) {
			Integer id = Integer.parseInt(id_string);
			DormStudent dormStudent = dormStudentServiceImpl.queryDormStudentById(id);
			Map<String, DormStudent> dataMap = new Hashtable<>();
			dataMap.put("dormStudent", dormStudent);
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@RequestMapping(value = "/checkStatus", method = RequestMethod.POST)
	public String checkStatus(HttpServletRequest request, HttpServletResponse response) {
		String id_string = request.getParameter("id");
		if (id_string != null) {
			Integer dormId = Integer.parseInt(id_string);
			List<DormStudent> volist = dormStudentServiceImpl.checkStatus(dormId);
			List<DormStudentVO> dormStudentVOList = new ArrayList<>();
			for (DormStudent dormStudent : volist) {
				Integer studentId = dormStudent.getStudentId();

				String studentName = studentServiceImpl.queryStudentById(studentId).getName();

				String studentNum = studentServiceImpl.queryStudentById(studentId).getStudentNum();

				String dormNum = dormServiceImpl.queryDormById(dormId).getDormNum();

				Integer capacity = dormServiceImpl.queryDormById(dormId).getCapacity();

				Integer headId = dormServiceImpl.queryDormById(dormId).getHeadId();

				DormStudentVO dormStudentVO = new DormStudentVO();
				dormStudentVO.setDsId(dormStudent.getDsId());
				dormStudentVO.setCapacity(capacity);


				if (StringUtils.isNotBlank(dormStudent.getCreateTime())) {
					dormStudentVO.setCreateTime(dormStudent.getCreateTime());
				}

				dormStudentVO.setDormId(dormId);

				if (StringUtils.isNotBlank(dormNum)) {
					dormStudentVO.setDormNum(dormNum);
				}

				dormStudentVO.setHeadId(headId);

				if (StringUtils.isNotBlank(dormStudent.getJoinTime())) {
					dormStudentVO.setJoinTime(dormStudent.getJoinTime());
				}

				if (StringUtils.isNotBlank(dormStudent.getLeaveReason())) {
					dormStudentVO.setLeaveReason(dormStudent.getLeaveReason());
				}

				if (StringUtils.isNotBlank(dormStudent.getLeaveTime())) {
					dormStudentVO.setLeaveTime(dormStudent.getLeaveTime());
				}
				if (StringUtils.isNotBlank(dormStudent.getRemark())) {
					dormStudentVO.setRemark(dormStudent.getRemark());
				}
				if (StringUtils.isNotBlank(studentName)) {
					dormStudentVO.setStudentName(studentName);
				}
				dormStudentVO.setStudentNum(studentNum);

				dormStudentVO.setStudentId(studentId);

				dormStudentVOList.add(dormStudentVO);
			}

			Map<String, List<DormStudentVO>> dataMap = new Hashtable<>();
			dataMap.put("dormStudentVOList", dormStudentVOList);
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@RequestMapping(value = "/distribute", method = RequestMethod.POST)
	public String distribute(HttpServletRequest request, HttpServletResponse response) {
		String studentNum = request.getParameter("studentNum");

		Student studentByStudentNum = studentServiceImpl.queryStudentByStudentNum(studentNum);

		if (studentByStudentNum == null) {
			Map<String, Object> dataMap = new Hashtable<>();
			dataMap.put("msg_distribute", "该学生不存在！");
			dataMap.put("success", "0");
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Integer student_id = studentByStudentNum.getStudentId();
			if (dormStudentServiceImpl.queryDormStudentByStudentId(student_id) != null) {
				Map<String, Object> dataMap = new Hashtable<>();
				dataMap.put("msg_distribute", "该学生已经分配了宿舍");
				dataMap.put("success", "0");
				JSONObject jsonObject = new JSONObject();
				jsonObject.putAll(dataMap);
				try {
					response.getWriter().write(jsonObject.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				DormStudent dormStudent = new DormStudent();
				String dorm_Id = request.getParameter("dormId");
				Integer dormId = Integer.parseInt(dorm_Id);
				Integer capacity = dormServiceImpl.queryCapicityByDormId(dormId);
				Integer countNow = dormStudentServiceImpl.queryCountNowByDormId(dormId);
				if (countNow >= capacity) {

					Map<String, Object> dataMap = new Hashtable<>();
					dataMap.put("msg_distribute", "宿舍已经达到最大人数");
					dataMap.put("success", "0");
					JSONObject jsonObject = new JSONObject();
					jsonObject.putAll(dataMap);
					try {
						response.getWriter().write(jsonObject.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					/*
					 * DormStudent dormStudent = new DormStudent(); String
					 * dorm_Id = request.getParameter("dormId");
					 */
					/*
					 * if(StringUtils.isNotBlank(dorm_Id)){
					 * dormStudent.setDormId(Integer.parseInt(dorm_Id)); }
					 */
					dormStudent.setDormId(Integer.parseInt(dorm_Id));
					String joinTime = request.getParameter("joinTime");
					String remark = request.getParameter("remark");

					Integer studentId = studentServiceImpl.queryStudentByStudentNum(studentNum).getStudentId();

					dormStudent.setStudentId(studentId);
					dormStudent.setJoinTime(joinTime);
					dormStudent.setRemark(remark);
					dormStudentServiceImpl.insertDormStudent(dormStudent);

					Map<String, Object> dataMap = new Hashtable<>();
					dataMap.put("msg_distribute", "分配成功");
					dataMap.put("success", "1");
					JSONObject jsonObject = new JSONObject();
					jsonObject.putAll(dataMap);
					try {
						response.getWriter().write(jsonObject.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return null;
	}

	@RequestMapping(value = "/makeHead", method = RequestMethod.POST)
	public String makeHead(HttpServletRequest request, HttpServletResponse response) {
		String dorm_Id = request.getParameter("dormId");
		String student_Id = request.getParameter("studentId");
		if (StringUtils.isNotBlank(dorm_Id) && StringUtils.isNotBlank(student_Id)) {

			Dorm dorm = new Dorm();
			dorm.setDormId(Integer.parseInt(dorm_Id));
			dorm.setHeadId(Integer.parseInt(student_Id));
			dormServiceImpl.updateDorm(dorm);
		}

		return null;
	}

	
	
	//自动分配
	@RequestMapping(value = "/distributeByTwoStudent", method = RequestMethod.POST)
	public String distributeByTwoStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Student> studentsWithoutDorm = queryAllStudentsWithoutDorm();
		Map<Integer,String> map  = new HashMap<>();
		
		if(studentsWithoutDorm==null){
			Map<String, Object> dataMap = new Hashtable<>();
			dataMap.put("msg_distribute", "所有学生已经分配宿舍！");
			dataMap.put("success", "0");
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			try {
				response.getWriter().write(jsonObject.toString());
				//跳出循环
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			for (Student student : studentsWithoutDorm) {
				map.put(student.getStudentId(), student.getHobby());
			}
		
			
			Map<String, Double> sortStudent = IKMainUtil.sortStudent(map);
			
			
			
			
			System.out.println("经过余弦相似度以及分词分析，每两位学生匹配后，得到的爱好相似程度排序后："+sortStudent);
			
			for (Map.Entry<String, Double> entry : sortStudent.entrySet()) { 
				String[] twoStudentId = entry.getKey().split("-");
				 //System.out.println("学生1学号为 ： " +twoStudentId[0]+"学生2学号为 ： " +twoStudentId[1] ); 
				  
				String stId1 = twoStudentId[0];
				String stId2 = twoStudentId[1];
				
				
				Integer studentId1 = Integer.valueOf(stId1);
				Integer studentId2 = Integer.valueOf(stId2);
				
				
				String studentNum1 = request.getParameter("studentNum1");
				String studentNum2 = request.getParameter("studentNum2");

				Student studentByStudentNum1 = studentServiceImpl.queryStudentById(studentId1);
				Student studentByStudentNum2 = studentServiceImpl.queryStudentById(studentId2);
				
				Dorm dorm = queryDormCanCotainsTwoStudents();

				if (dorm == null) {
					Map<String, Object> dataMap = new Hashtable<>();
					dataMap.put("msg_distribute", "不存在能分配两个学生的宿舍，请先增加一些能容纳两个学生的宿舍！");
					dataMap.put("success", "0");
					JSONObject jsonObject = new JSONObject();
					jsonObject.putAll(dataMap);
					try {
						response.getWriter().write(jsonObject.toString());
						//跳出循环
						break;
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					if (studentByStudentNum1 == null || studentByStudentNum2 == null) {
						Map<String, Object> dataMap = new Hashtable<>();
						dataMap.put("msg_distribute", "学生不存在！");
						dataMap.put("success", "0");
						JSONObject jsonObject = new JSONObject();
						jsonObject.putAll(dataMap);
						try {
							response.getWriter().write(jsonObject.toString());
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						Integer dormId = dorm.getDormId();
						Integer capacity = dormServiceImpl.queryCapicityByDormId(dormId);
						Integer countNow = dormStudentServiceImpl.queryCountNowByDormId(dormId);
						if (countNow + 2 > capacity) {

							Map<String, Object> dataMap = new Hashtable<>();
							dataMap.put("msg_distribute", "宿舍已经达到最大人数或宿舍容量不足两个人");
							dataMap.put("success", "0");
							JSONObject jsonObject = new JSONObject();
							jsonObject.putAll(dataMap);
							try {
								response.getWriter().write(jsonObject.toString());
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {

							Integer student_id1 = studentByStudentNum1.getStudentId();
							Integer student_id2 = studentByStudentNum2.getStudentId();
							if (dormStudentServiceImpl.queryDormStudentByStudentId(student_id1) != null
									&& dormStudentServiceImpl.queryDormStudentByStudentId(student_id2) != null) {
								Map<String, Object> dataMap = new Hashtable<>();
								dataMap.put("msg_distribute", "两个都学生已经分配了宿舍");
								dataMap.put("success", "1");
								JSONObject jsonObject = new JSONObject();
								jsonObject.putAll(dataMap);
								try {
									response.getWriter().write(jsonObject.toString());
								} catch (IOException e) {
									e.printStackTrace();
								}
							} else {

								int result = dormStudentServiceImpl.distributeByTwoStudent(student_id1, student_id2, dormId);
								if (result == 1) {
									Map<String, Object> dataMap = new Hashtable<>();
									dataMap.put("msg_distribute", "学生1分配成功");
									dataMap.put("success", "1");
									JSONObject jsonObject = new JSONObject();
									jsonObject.putAll(dataMap);
									try {
										response.getWriter().write(jsonObject.toString());
									} catch (IOException e) {
										e.printStackTrace();
									}
								} else if (result == 2) {
									Map<String, Object> dataMap = new Hashtable<>();
									dataMap.put("msg_distribute", "学生2分配成功");
									dataMap.put("success", "1");
									JSONObject jsonObject = new JSONObject();
									jsonObject.putAll(dataMap);
									try {
										response.getWriter().write(jsonObject.toString());
									} catch (IOException e) {
										e.printStackTrace();
									}
								} else if (result == 12) {
									Map<String, Object> dataMap = new Hashtable<>();
									dataMap.put("msg_distribute", "两位学生都分配成功");
									dataMap.put("success", "1");
									JSONObject jsonObject = new JSONObject();
									jsonObject.putAll(dataMap);
									try {
										response.getWriter().write(jsonObject.toString());
									} catch (IOException e) {
										e.printStackTrace();
									}
								} else {
									Map<String, Object> dataMap = new Hashtable<>();
									dataMap.put("msg_distribute", "分配失败");
									dataMap.put("success", "0");
									JSONObject jsonObject = new JSONObject();
									jsonObject.putAll(dataMap);
									try {
										response.getWriter().write(jsonObject.toString());
									} catch (IOException e) {
										e.printStackTrace();
									}
								}

							}

						}

					}
				}
				
			}
		}
		

		
		
		

		return null;
	}
	
	@RequestMapping(value = "/queryDormsCanCotainsTwoStudents", method = RequestMethod.POST)
	@ResponseBody
	public Dorm queryDormCanCotainsTwoStudents() {
		List<Dorm> list = dormServiceImpl.queryDormsCapicityOverTwo();
		//Map<Dorm, Integer> map = new HashMap<Dorm, Integer>();
		List<Dorm> returnlist = new ArrayList<>();
		for (Dorm dorm : list) {
			Integer dormId = dorm.getDormId();
			Integer capacity = dormServiceImpl.queryCapicityByDormId(dormId);
			Integer countNow = dormStudentServiceImpl.queryCountNowByDormId(dormId);
			if (capacity >= countNow && capacity - countNow >= 2) {
				/*map.put(dorm, capacity - countNow);*/
				returnlist.add(dorm);
			}
		}
		/*if(map!=null&&map.size()>0){
		return map;
		}else{
			return null;
		}*/
		
		if(returnlist!=null&&returnlist.size()>0){
			return returnlist.get(0);
			}else{
				return null;
			}
		
	}
	
	
	
	List<Student> queryAllStudentsWithoutDorm(){
		List<Student> students = studentServiceImpl.queryAllStudents();
		List<Student> studentsWithoutDorm = new ArrayList<>(); 
		for (Student student : students) {
			if(dormStudentServiceImpl.queryDormStudentByStudentId(student.getStudentId())==null){
				studentsWithoutDorm.add(student);
			}
		}
		
		if(studentsWithoutDorm!=null&&studentsWithoutDorm.size()>0){
			return studentsWithoutDorm;
		}else{
			return null;
		}
	}

}
