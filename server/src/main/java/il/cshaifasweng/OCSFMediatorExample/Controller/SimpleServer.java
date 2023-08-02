package il.cshaifasweng.OCSFMediatorExample.Controller;
import il.cshaifasweng.OCSFMediatorExample.client.SimpleChatClient;
import il.cshaifasweng.OCSFMediatorExample.entities.*;
import il.cshaifasweng.OCSFMediatorExample.Controller.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.Controller.ocsf.ConnectionToClient;
import il.cshaifasweng.OCSFMediatorExample.Controller.ocsf.SubscribedClient;
import javafx.application.Platform;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.*;

public class SimpleServer extends AbstractServer {

	//private static final SessionFactory sessionFactory = getSessionFactory();
	private static Session session;
	private static ArrayList<SubscribedClient> SubscribersList = new ArrayList<>();
	public static void generate()
	{

		session.beginTransaction();

//		User user1 = new User("rami", "simaan", "ramisi7", "123", 0);
//		session.save(user1);
//		Question Q1 = new Question("what is 1+2", "0", "1","2","3");
//		session.save(Q1);
		//User user2 = new User("yazan", "yehya", "yazan9", "1234", 1);
		//User user3 = new User("ahmad", "ig", "ahmad", "1234", 1);
		//Subject math = new Subject("math");
		//Subject english = new Subject("English");
		//session.save(english);
		//User user4 = new Teacher("yazan", "yehya", "yazan9", "1234", 1,math);
		//User user5 = new Teacher("chris", "bumstead", "cbum", "5", 1,english);
		//session.save(user5);
//		Course electronics = new Course("electronic");
//		Subject physics = new Subject("physics");
//
//		Teacher teacher = new Teacher("raghad", "susan", "raghad7", "178",1,physics );
//		teacher.getCourses().add(electronics);
//		electronics.getListOfTeachers().add(teacher);
//		teacher.setSubject(physics);
//		session.save(physics);
//		session.save(electronics);
//		session.save(teacher);


		Subject sports = new Subject("Sports");
		Course football = new Course("Football");
		Course basketball = new Course("Basketball");
		Course golf = new Course("Golf");
		sports.getCourses().add(football);
		sports.getCourses().add(golf);
		sports.getCourses().add(basketball);
		football.setSubject(sports);
		basketball.setSubject(sports);
		golf.setSubject(sports);


		Subject math = new Subject("Math");
		Course lierarAlgebra = new Course("Linear Algebra");
		Course calculus = new Course("Calculus");
		Course geometry = new Course("Geometry");
		math.getCourses().add(lierarAlgebra);
		math.getCourses().add(calculus);
		math.getCourses().add(geometry);
		lierarAlgebra.setSubject(math);
		calculus.setSubject(math);
		geometry.setSubject(math);



		Teacher cr7 = new Teacher("Cristiano", "Ronaldo", "cr7", "123", 1);

		cr7.getSubjects().add(sports);
		cr7.getSubjects().add(math);
		cr7.getCourses().add(lierarAlgebra);
		cr7.getCourses().add(geometry);
		cr7.getCourses().add(football);

		sports.getListOfTeachers().add(cr7);
		football.getListOfTeachers().add(cr7);

		math.getListOfTeachers().add(cr7);
		lierarAlgebra.getListOfTeachers().add(cr7);
		geometry.getListOfTeachers().add(cr7);


		Teacher gBale = new Teacher("Gareth", "Bale", "bale11", "123", 1);
		gBale.getSubjects().add(sports);
		gBale.getCourses().add(golf);
		gBale.getCourses().add(football);
		sports.getListOfTeachers().add(gBale);
		golf.getListOfTeachers().add(gBale);
		football.getListOfTeachers().add(gBale);


		Teacher benzema = new Teacher("Karim", "Benzema", "kb9", "123", 1);
		benzema.getSubjects().add(sports);
		benzema.getCourses().add(football);
		football.getListOfTeachers().add(benzema);
		sports.getListOfTeachers().add(benzema);
		math.getListOfTeachers().add(benzema);
		benzema.getSubjects().add(math);
		benzema.getCourses().add(calculus);
		calculus.getListOfTeachers().add(benzema);

		Student lucas = new Student("Lucas", "Vazques", "lv17","123",0);
		lucas.getCourses().add(football);
		football.getListOfStudents().add(lucas);
		lucas.getSubjects().add(sports);
		sports.getListOfStudents().add(lucas);

		Student mariano = new Student("Mariano", "Diaz", "md25","123",0);
		mariano.getCourses().add(football);
		football.getListOfStudents().add(mariano);
		mariano.getCourses().add(golf);
		golf.getListOfStudents().add(mariano);

		mariano.getSubjects().add(sports);
		sports.getListOfStudents().add(mariano);

		Principle principle1 = new Principle("Haifa", "University","haifa", "123",2);
		principle1.getCourses().add(football);
		principle1.getCourses().add(basketball);
		principle1.getCourses().add(golf);
		principle1.getCourses().add(lierarAlgebra);
		principle1.getCourses().add(calculus);
		principle1.getCourses().add(geometry);
		principle1.getSubjects().add(sports);
		principle1.getSubjects().add(math);
		principle1.getTeachers().add(cr7);
		principle1.getTeachers().add(gBale);
		principle1.getTeachers().add(benzema);
		football.setPrinciple(principle1);
		basketball.setPrinciple(principle1);
		golf.setPrinciple(principle1);
		lierarAlgebra.setPrinciple(principle1);
		calculus.setPrinciple(principle1);
		geometry.setPrinciple(principle1);
		sports.setPrinciple(principle1);
		math.setPrinciple(principle1);
		cr7.setPrinciple(principle1);
		gBale.setPrinciple(principle1);
		benzema.setPrinciple(principle1);


		session.save(cr7);
		session.save(gBale);
		session.save(benzema);
		session.save(lucas);
		session.save(mariano);
		session.save(principle1);


		session.save(sports);
		session.save(math);

		session.save(lierarAlgebra);
		session.save(calculus);
		session.save(geometry);
		session.save(football);
		session.save(basketball);
		session.save(golf);


		session.flush();
		session.getTransaction().commit();

	}
	public SimpleServer(int port)
	{
		super(port);
		SessionFactory sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		//generate();
	}

	public User getUserByUsername(String username, String password, Message resMessage) {
		try {
			Query query = session.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
			query.setParameter("username", username);

			User user = null;
			try {
				user = (User) query.getSingleResult();
			} catch (NoResultException ex) {
			}

			if (user != null && user.getPassword().equals(password) && !user.isLoggedIn()) {
				user.setLoggedIn(true);
				session.update(user);
				session.getTransaction().commit();
				return user;
			} else if (user != null && user.getPassword().equals(password) && user.isLoggedIn()) {
				resMessage.setTitle("already logged in");
				return null;
			} else {
				System.out.println("Incorrect username or password");
				return null;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	public List<Question> getQuestionsForCourse(Course course) {
		try (Session session = getSessionFactory().openSession()) {
			// Retrieve the course from the database to ensure it's managed
			Course managedCourse = session.get(Course.class, course.getId());
			Hibernate.initialize(managedCourse.getListOfQuestions());
			// Get the questions associated with the course
			List<Question> questions = managedCourse.getListOfQuestions();
			return questions;
		}
	}

	public List<Exam> getExamsForCourse(Course course) {
		// Create a Hibernate session
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the questions for the given course ID
			String hql = "SELECT e FROM Exam e WHERE e.course.name = :courseName AND e.isClone = 'no'";
			Query query = session.createQuery(hql, Exam.class);
			query.setParameter("courseName", course.getName());

			// Execute the query and retrieve the list of questions
			List<Exam> exams = query.getResultList();
			return exams;
		}
	}
	public List<ReadyExam> getReadyExamsForCourse(Object[] objects) {
		// Create a Hibernate session

		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the ReadyExams with the associated Exam eagerly

			Course course = (Course) objects[0];
			Teacher teacher = (Teacher) objects[1];
			String hql = "SELECT re FROM ReadyExam re JOIN FETCH re.exam WHERE re.exam.course.name = :course AND re.isClone = 'no' AND re.username = : username";
			Query query = session.createQuery(hql, ReadyExam.class);
			query.setParameter("course", course.getName());
			query.setParameter("username",teacher.getUsername());

			// Execute the query and retrieve the list of ReadyExams
			List<ReadyExam> exams = query.getResultList();
			return exams;
		}
	}
	public List<ReadyExam> getReadyExamsToApprove(Object[] objects)
	{
		// Create a Hibernate session
		System.out.println("lolllkkkkkkkk");
		try (Session session = getSessionFactory().openSession()) {

			Course course = (Course) objects[0];
			Teacher teacher = (Teacher) objects[1];
			String hql = "SELECT re FROM ReadyExam re JOIN FETCH re.exam WHERE re.exam.course.name = :course AND re.isClone = 'yes' AND re.approved = 'no' AND re.username = : username";
			Query query = session.createQuery(hql, ReadyExam.class);
			query.setParameter("course", course.getName());
			query.setParameter("username",teacher.getUsername());

			// Execute the query and retrieve the list of ReadyExams
			List<ReadyExam> exams = query.getResultList();
			return exams;
		}
	}
	public List<Question> getQuestionsForCoursePrinciple(Course course) {
		// Create a Hibernate session
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the questions for the given course ID
			//String hql = "FROM Question q WHERE q.course. = :courseName";
			String hql = "select q from Question  q JOIN q.course c where c.id =:courseId";

			//String hql = "SELECT e FROM Exam e JOIN e.listOfStudents s WHERE s.id = :studentId";

			Query query = session.createQuery(hql, Question.class);
			query.setParameter("courseId", course.getName());

			// Execute the query and retrieve the list of questions
			List<Question> questions = query.getResultList();
			return questions;
		}
	}
	public List<ReadyExam> getExamsForStudent(Student student) {
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the exams for the given teacher ID
			String hql = "SELECT e FROM ReadyExam e JOIN e.listOfStudents s WHERE s.id = :studentId";
			Query query = session.createQuery(hql, ReadyExam.class);
			query.setParameter("studentId", student.getId());

			// Execute the query and retrieve the list of subjects
			List<ReadyExam> exams = query.getResultList();
			return exams;
		}
	}

	public List<Exam> getExamsForTeacher(Teacher teacher) {
		// Create a Hibernate session
		System.out.println("get Exams For Teacher " + teacher.getFirstName() + teacher.getLastName());
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the questions for the given teacher ID
			//String hql = "FROM Exam e WHERE e.username = :teacherName";
			String hql = "SELECT e FROM Exam e WHERE e.username = :teacherName";

			Query query = session.createQuery(hql, Exam.class);
			query.setParameter("teacherName", teacher.getUsername());

			// Execute the query and retrieve the list of questions
			List<Exam> exams = query.getResultList();
			return exams;
		}
	}

	public List<Subject> getSubjectsForTeacher(Teacher teacher) {
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the subjects for the given teacher ID
			String hql = "SELECT s FROM Subject s JOIN s.listOfTeachers t WHERE t.id = :teacherId";
			Query query = session.createQuery(hql, Subject.class);
			query.setParameter("teacherId", teacher.getId());

			// Execute the query and retrieve the list of subjects
			List<Subject> subjects = query.getResultList();
			return subjects;
		}
	}
	public List<Subject> getSubjectsForPrinciple(Principle principle) {
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the subjects for the given principle ID
			//String hql = "SELECT s FROM Subject s JOIN s.principle p WHERE p.id = :principleId";
			String hql = "SELECT s FROM Subject s";
			Query query = session.createQuery(hql, Subject.class);
			//query.setParameter("principleId", principle.getId());

			// Execute the query and retrieve the list of subjects
			List<Subject> subjects = query.getResultList();
			return subjects;
		}
	}
	public List<Teacher> getTeachersForPrinciple(Principle principle) {
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the subjects for the given principle ID
			String hql = " SELECT t FROM Teacher t";
			Query query = session.createQuery(hql, Teacher.class);

			// Execute the query and retrieve the list of subjects
			List<Teacher> teachers = query.getResultList();
			return teachers;
		}
	}

	public List<Course> getCoursesForPrinciple(Principle principle) {
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the subjects for the given principle ID
			String hql = "SELECT c FROM Course c";
			Query query = session.createQuery(hql, Course.class);

			// Execute the query and retrieve the list of subjects
			List<Course> courses = query.getResultList();
			return courses;
		}
	}
	public List<Student> getStudentsForPrinciple(Principle principle) {
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the subjects for the given principle ID
			String hql = "SELECT s FROM Student s";
			Query query = session.createQuery(hql, Student.class);

			// Execute the query and retrieve the list of subjects
			List<Student> students = query.getResultList();
			return students;
		}
	}
//	public List<Course> getCoursesForSubject(Subject subject) {
//		try (Session session = getSessionFactory().openSession()) {
//			// Create a query to fetch the courses for the given subject
//			String hql = "SELECT c FROM Course c WHERE c.subject = :subject";
//			Query query = session.createQuery(hql, Course.class);
//			query.setParameter("subject", subject);
//
//			// Execute the query and retrieve the list of courses
//			List<Course> courses = query.getResultList();
//			return courses;
//		}
//	}
	//	public User getUserByUsername(String username, String password) {
//		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//		try {
//
//			//session.beginTransaction();
//			System.out.println("lolll");
//			Query query = session.createQuery("FROM User WHERE username = :username", User.class);
//			System.out.println("ddddd");
//			query.setParameter("username", username);
//			System.out.println("3333666");
//			User user = (User)query.getSingleResult();
//			System.out.println("3333");
//			session.getTransaction().commit();
//			System.out.println("44444");
//			if (user != null && user.getPassword().equals(password)) {
//				System.out.println("5555");
//				return user;
//			} else {
//				System.out.println("666666");
//				return null;
//			}
//		}
//		catch (Exception e) {
//			session.getTransaction().rollback();
//			throw e;
//		} finally {
//			session.close();
//	}
//		}

	public List<Student> getStudentsForCourse(Course course)
	{
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the subjects for the given teacher ID
			String hql = "SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId";
			Query query = session.createQuery(hql, Student.class);
			query.setParameter("courseId", course.getId());

			// Execute the query and retrieve the list of subjects
			List<Student> students = query.getResultList();
			return students;
		}
	}
//	public List<Subject> getSubjectsForTeacher(Teacher teacher) {
//		try (Session session = getSessionFactory().openSession()) {
//			// Create a query to fetch the subjects for the given teacher ID
//			String hql = "SELECT s FROM Subject s JOIN s.listOfTeachers t WHERE t.id = :teacherId";
//			Query query = session.createQuery(hql, Subject.class);
//			query.setParameter("teacherId", teacher.getId());
//
//			// Execute the query and retrieve the list of subjects
//			List<Subject> subjects = query.getResultList();
//			return subjects;
//		}
//	}
	public List<Course> getCoursesForSubject(Subject subject) {
		try (Session session = getSessionFactory().openSession()) {
			// Create a query to fetch the courses for the given subject
			String hql = "SELECT c FROM Course c WHERE c.subject = :subject";
			Query query = session.createQuery(hql, Course.class);
			query.setParameter("subject", subject);

			// Execute the query and retrieve the list of courses
			List<Course> courses = query.getResultList();
			return courses;
		}
	}




	@Override
	public void handleMessageFromClient(Object msg, ConnectionToClient client) throws IOException {
		System.out.println("incline bench press111");
		Message message = (Message) msg;
		System.out.println(message.getTitle());
		if ("Login".equals(message.getTitle()))
		{
			if (!session.getTransaction().isActive()) {
				session = getSessionFactory().openSession();
				session.beginTransaction();
			}
			Object[] body = (Object[]) message.getBody();
			String username = (String) body[0];
			String password = (String) body[1];
			Message msg1 = new Message("", null);
			User user = getUserByUsername(username, password, msg1);
			System.out.println(msg1.getTitle());
			if (msg1.getTitle().equals("already logged in")) {
				message.setTitle("already logged in");
			}
			System.out.println("2222");
			Message responseMessage = new Message(message.getTitle(), user);
			client.sendToClient(responseMessage);

			if (session != null && session.isOpen()) {
				session.getTransaction().commit();
				session.close();
			}
		}
		else if ("NewClient".equals(message.getTitle()))
		{
			SubscribedClient newSub = new SubscribedClient(client);
			SubscribersList.add(newSub);
		}
		else if("getSubjects".equals(message.getTitle()))
		{
			Teacher teacher = (Teacher)message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				List<Subject> list = getSubjectsForTeacher(teacher);
				for (Subject s : list)
				{
					System.out.println(s.getName() + "+ size: " + list.size());
				}
				Message resMessage = new Message("getSubjects", list);
				client.sendToClient(resMessage);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}

		}
		else if("showQuestions".equals(message.getTitle()) || "showQuestionsForPrinciple".equals(message.getTitle()) || "getAllQuestions".equals(message.getTitle()))
		{
			Course course = (Course) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				List<Question> list = getQuestionsForCourse(course);
				//List<Question> questionList = new ArrayList<Question>();
				System.out.println("size of list = " + list.size());
//				if ("getAllQuestions".equals(message.getTitle()))
//				{
//					for (Question l : list)
//					{
//						l.setScore(0);
//					}
//				}
				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("showQuestionsForPrinciple".equals(message.getTitle()))
		{
			Course course = (Course) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				List<Question> list = getQuestionsForCourse(course);
				//List<Question> list = getQuestionsForCoursePrinciple(course);
				//List<Question> questionList = new ArrayList<Question>();
				System.out.println("size of list = " + list.size());
//				if ("getAllQuestions".equals(message.getTitle()))
//				{
//					for (Question l : list)
//					{
//						l.setScore(0);
//					}
//				}
				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("showStudents".equals(message.getTitle()))
		{
			Course course = (Course) message.getBody();

			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive())
				{
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				List<Student> students = getStudentsForCourse(course);
				Message resMessage = new Message(message.getTitle(), students);
				client.sendToClient(resMessage);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("sendToStudent".equals(message.getTitle()))
		{
			Object[] objects = (Object[])message.getBody();
			List<String> students = (List<String>)objects[0];
			ReadyExam readyExam = (ReadyExam)objects[1];
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
//				List<Question> questionList = new ArrayList<Question>();
//				for (Question q : readyExam.getExam().getListOfQuestions())
//				{
//					Question question = q.clone();
//					question.setScore(q.getScore());
//					questionList.add(question);
//					session.save(question);
//				}
//				Exam exam = readyExam.getExam().clone();
//				exam.setListOfQuestions(questionList);
//				session.save(exam);
//				ReadyExam readyExam1 = new ReadyExam(readyExam.getExamType(), readyExam.getCourse(), readyExam.getExecutionCode(), exam, "yes");
//				session.save(readyExam1);
				String hql = "SELECT re FROM ReadyExam re WHERE re.id = :id";
				Query query = session.createQuery(hql, ReadyExam.class);
				query.setParameter("id", readyExam.getId());
				ReadyExam re = (ReadyExam) query.getSingleResult();
				for (String str : students)
				{
					hql = "SELECT s FROM Student s WHERE s.username = :username";
					Query query1 = session.createQuery(hql, Student.class);
					query1.setParameter("username", str);
					Student student = (Student) query1.getSingleResult();
					student.getExams().add(re);
					re.getListOfStudents().add(student);
					System.out.println("before update");
					session.update(student);
					session.flush();
					System.out.println("after update");
					session.update(re);
					session.flush();
				}
				//session.save(readyExam1);
				Message responseMessage = new Message("sendToStudent", null);
				client.sendToClient(responseMessage);
			} catch (HibernateException e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}

		}
		else if("changeToStartExam".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive())
				{
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Object[] objects = (Object[]) message.getBody();
				String executionCode = (String) objects[0];
				String id = (String) objects[1];
				Student student = (Student) objects[2];
				ReadyExam re = null;
				String hql = "SELECT e FROM ReadyExam e JOIN e.listOfStudents s WHERE s.username = :username";
				Query query = session.createQuery(hql, ReadyExam.class);
				query.setParameter("username", student.getUsername());
				List<ReadyExam> readyExamList = query.getResultList();
				for (ReadyExam readyExam : readyExamList)
				{
					if (Objects.equals(readyExam.getExecutionCode(), executionCode))
					{
						re = readyExam;
					}
				}
				if (re != null && Objects.equals(id, Integer.toString(student.getId())))
				{
					Message resMessage = new Message("changeToStartExam", re);
					client.sendToClient(resMessage);
				}
				else
				{
					String s = "";
					if (re == null && Objects.equals(id, Integer.toString(student.getId())))// no available exam
					{
						s = "1";
					}
					else if(re != null && !Objects.equals(id, Integer.toString(student.getId()))) // wrong id
					{
						s = "2";
					}
					else
					{
						s = "3";
					}
					Object obj = new Object[]{s};
					Message resMessage = new Message("startExamFailed", obj);
					client.sendToClient(resMessage);
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("StartSolvingComputerizedExam".equals(message.getTitle()) || "StartSolvingManualExam".equals(message.getTitle()) )
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}

				Object[] objects = (Object[]) message.getBody();
				ReadyExam readyExam = (ReadyExam)objects[0];
				Student student = (Student)objects[1];
				List<Question> questionList = new ArrayList<Question>();
				for (Question q : readyExam.getExam().getListOfQuestions()) {
					Question question = q.clone();
					question.setScore(q.getScore());
					questionList.add(question);
					session.save(question);
				}
				Exam exam = readyExam.getExam().clone();
				exam.setListOfQuestions(questionList);
				session.save(exam);
				ReadyExam readyExam1 = new ReadyExam(readyExam.getExamType(), readyExam.getCourse(), readyExam.getExecutionCode(), exam, "yes", readyExam.getUsername(), readyExam.getExam().getId(), student.getFirstName() + " " + student.getLastName() ,Integer.toString(student.getId()));
				readyExam1.setExaminee(student.getUsername());
				session.flush();
				readyExam1.setReadyExamOriginalID(readyExam.getId());
				session.save(readyExam1);
				Message responseMessage = new Message(message.getTitle(), readyExam1);
				client.sendToClient(responseMessage);

			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("showExams".equals(message.getTitle()) || "showExamsAE".equals(message.getTitle()) || "showExamsForPrinciple".equals(message.getTitle()))
		{
			Course course = (Course) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				List<Exam> list = getExamsForCourse(course);
				System.out.println("size of list = " + list.size());
				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("editSelectedQuestion".equals(message.getTitle()))
		{
			client.sendToClient(message);
		}
		else if ("getSubjectsForTeacher".equals(message.getTitle()) || "getSubjectsForTeacherEQ".equals(message.getTitle()) || "getSubjectsForTeacherExam".equals(message.getTitle()) || "getSubjectsForTeacherAE".equals(message.getTitle()) || "getSubjectsForTeacherSE".equals(message.getTitle()) || "getSubjectsForTeacherAPP".equals(message.getTitle()) || "viewGradesForTeacherSubjects".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Teacher teacher = (Teacher) message.getBody();
				List<Subject> subjects = getSubjectsForTeacher(teacher);
				Message resMessage = new Message(message.getTitle(), subjects);
				client.sendToClient(resMessage);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if ("getCoursesForSubjects".equals(message.getTitle()) || "getCoursesForSubjectsEQ".equals(message.getTitle()) || "getCoursesForSubjectsExam".equals(message.getTitle()) || "getCourses".equals(message.getTitle()) || "getCoursesAE".equals(message.getTitle()) || "getCoursesSE".equals(message.getTitle()) || "getCoursesAPP".equals(message.getTitle()) || "viewGradesForTeacherCourses".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Subject subject = (Subject) message.getBody();
				List<Course> courses = getCoursesForSubject(subject);
				Message resMessage = new Message(message.getTitle(), courses);
				client.sendToClient(resMessage);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("editSelectedExam".equals(message.getTitle()))
		{
			try
			{
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				System.out.println("editSelectedExam");
				Exam exam = (Exam) message.getBody();
				List<Question> list = exam.getListOfQuestions();
				for (Question l : list)
				{
					System.out.println(l.getQText() + "   score: ");
				}
				Message resMessage = new Message("editSelectedExam", exam);
				client.sendToClient(resMessage);

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if ("Logout".equals(message.getTitle()) || "LogoutForStudent".equals(message.getTitle())|| "Logout principle".equals(message.getTitle()))
		{
			SubscribersList.remove(message.getBody());
			User temp = (User) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				User user = session.find(User.class, temp.getId());
				user.setLoggedIn(false);
				session.update(user);
				session.flush(); // Manually flush the session
				session.getTransaction().commit(); // Commit the transaction
				client.sendToClient(message);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			System.out.println("logout");
		}
		else if ("createQuestion".equals(message.getTitle()) || "saveEditedQuestion".equals(message.getTitle())) {
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}

				List<String> list = (List<String>) message.getBody();
				Question question = null;
				if (list != null)
				{
					String hql1 = "SELECT s FROM Subject s WHERE s.name = :subject";
					Query query = session.createQuery(hql1, Subject.class);
					query.setParameter("subject", list.get(5));
					Subject subject = (Subject)query.getSingleResult();
					if (subject!= null)
					{
						System.out.println(subject.getId());
					}
					else
					{
						System.out.println("nukllllllll");
					}
					String jpql = "SELECT t FROM Teacher t WHERE t.username = :username";
					query = session.createQuery(jpql, Teacher.class);
					query.setParameter("username", list.get(6));
					Teacher teacher = (Teacher)query.getSingleResult();
					if (teacher!= null)
					{
						System.out.println(teacher.getId());
					}
					else
					{
						System.out.println("nukllllllll111");
					}
					//question = new Question(list.get(0),list.get(1), list.get(2), list.get(3),list.get(4), subject,teacher, list.get(7));
					List<Course> courses = new ArrayList<Course>();
					for (int i = 8 ; i < list.size(); i++)
					{
						String hql = "SELECT c FROM Course c WHERE c.name = :course";
						Query query1 = session.createQuery(hql, Course.class);
						query1.setParameter("course", list.get(i));
						Course course = (Course) query1.getSingleResult();
						if (course!= null)
						{
							System.out.println(course.getId());
						}
						else
						{
							System.out.println("nukllllllll222222");
						}
						courses.add(course);

						//course.getListOfQuestions().add(question);
					}
					System.out.println("here before creating quesuion");
					question = new Question(list.get(0),list.get(1), list.get(2), list.get(3),list.get(4), subject,teacher, list.get(7), courses, "no");
					System.out.println("here after creating quesuion");
					session.save(question);
					System.out.println("lolllll");
//					String hql = "SELECT c FROM Course c WHERE c.name = :course";
//					Query query1 = session.createQuery(hql, Subject.class);
//					query1.setParameter("course", list.get(4));
					session.getTransaction().commit();
				}
				Message responseMessage = new Message(message.getTitle(), question);
				client.sendToClient(responseMessage);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		 else if ("createExam".equals(message.getTitle())) {
			try {
				if (session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				System.out.println("we are here");
				List<Question> list = getQuestionsForCourse((Course) message.getBody());
				Message responseMessage = new Message(message.getTitle(), list);
				System.out.println("gggggggggg");
				client.sendToClient(responseMessage);
				System.out.println("gggggggggg");
			} catch (Exception e) {
				if (session.getTransaction() != null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
				e.printStackTrace();
			} finally {
				// Close the session
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if ("saveExam".equals(message.getTitle()) || "saveEditedExam".equals(message.getTitle()))
		{
			System.out.println("incline bench press2");
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}

				System.out.println("incline bench press3");
				if ((ExamHelper) message.getBody() == null) {
					System.out.println("null");
				} else {
					System.out.println("john cena");
				}
				ExamHelper examHelper = (ExamHelper) message.getBody();

				if (examHelper.getQuestionHashMap() != null) {
					System.out.println(examHelper.getQuestionHashMap().size());
					System.out.println("raghad");
				}
				if (examHelper.getExamPeriod() != null) {
					System.out.println("raghad");
				}
				if (examHelper.getExamPeriod() == null ||
						examHelper.getQuestionHashMap() == null)
				{
					Message newMessage = new Message(message.getTitle(), null);
					client.sendToClient(newMessage);
					System.out.println("null exam");
				}
				else
				{
					String examPeriod = examHelper.getExamPeriod();
					System.out.println("incline bench press4");
					System.out.println(examHelper.getCourse());
					String hql1 = "SELECT s FROM Subject s WHERE s.name = :subject";
					Query query = session.createQuery(hql1, Subject.class);
					query.setParameter("subject", examHelper.getSubject());
					Subject subject = (Subject)query.getSingleResult();
					String hql = "SELECT c FROM Course c WHERE c.name = :course";
					Query query1 = session.createQuery(hql, Course.class);
					query1.setParameter("course", examHelper.getCourse());
					Course course = (Course) query1.getSingleResult();
					Exam exam = new Exam(examHelper.getUsername(), examPeriod, subject, course, examHelper.teacherComments, examHelper.allComments, "no");
					System.out.println("incline bench press5");
					List<Question> list1 = new ArrayList<Question>(examHelper.getQuestionHashMap().keySet());
					List<Question> list2 = new ArrayList<Question>();
					for (Question q : list1)
					{
						list2.add(q.clone());
					}
					List<Question> newQuestions = new ArrayList<>();
					//exam.setListOfQuestions(list);
//					for (Question question : list1) {
//						if (examHelper.getQuestionHashMap().containsKey(question))
//						{
//							int score = examHelper.getQuestionHashMap().get(question);
//							question.setScore(score);
//						}
//						// Check if the question already exists in the database
//						if (question.getId() == 0)
//						{
//							// New question, save it to generate an ID
//							//question.getExams().add(exam);
//							session.save(question);
//							newQuestions.add(question);
//						}
//
//						// Set the score for the question
//
//						// Associate the question with the exam
//					}
					for (int i = 0; i < list1.size(); i++)
					{
						if (examHelper.getQuestionHashMap().containsKey(list1.get(i)))
						{
							int score = examHelper.getQuestionHashMap().get(list1.get(i));
							list2.get(i).setScore(score);
							session.save(list2.get(i));
						}
					}
					exam.getListOfQuestions().addAll(list2);
					double sum = 0;
					boolean flag = true;
					for (Question q : exam.getListOfQuestions())
					{
						if (q.getScore() <= 0)
						{
							flag = false;
						}
						sum += q.getScore();
					}
					if (sum > 100 || sum < 100)
					{
						flag = false;
					}
					System.out.println("incline bench press6");
					if (flag)
					{
						session.save(exam);
					}
					System.out.println("incline bench press7");
					session.getTransaction().commit();
					System.out.println("saved");
					Message newMessage = new Message(message.getTitle(), exam);
					client.sendToClient(newMessage);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if (message.getTitle().equals("aquireExam"))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive())
				{
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Object[] objects = (Object[])message.getBody();

				List<Integer> list = (List<Integer>)objects[0];
				String hql = "SELECT e FROM Exam e WHERE e.id = :id";
				Query query1 = session.createQuery(hql, Exam.class);
				query1.setParameter("id", list.get(0));
				Exam exam = (Exam) query1.getSingleResult();
				System.out.println(exam.getUsername());
				String examType = "";
				if (list.get(1) == -1)
				{
					examType = "Manual";
				}
				else
				{
					examType = "Computerized";
				}
				String executionCode = (String) objects[1];
				Teacher teacher = (Teacher)objects[2];
				ReadyExam readyExam = new ReadyExam(examType, exam.getCourse().getName(),executionCode,exam, "no", teacher.getUsername(), exam.getId(), "", "");
				if (readyExam.getExam() == null)
				{
					System.out.println("hello bitch");
				}
				session.save(readyExam);
				readyExam.setReadyExamOriginalID(readyExam.getId());
				session.update(readyExam);
				session.flush();
				if (readyExam.getExam() == null)
				{
					System.out.println("hello bitch");
				}
				Message responseMessage  = new Message(message.getTitle(), readyExam);
				client.sendToClient(responseMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if (message.getTitle().equals("showReadyExams") || message.getTitle().equals("showReadyExamsAPP"))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive())
				{
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Object[] objects = (Object[])message.getBody();
				List<ReadyExam> list = null;

				if (message.getTitle().equals("showReadyExams"))
				{
					list = getReadyExamsForCourse(objects);
				}
				else
				{
					System.out.println("lolllllll");
					list = getReadyExamsToApprove(objects);
				}
				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if(message.getTitle().equals("finishExam"))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive())
				{
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Object[] objects = (Object[]) message.getBody();
				Map<Question,String> map = (Map<Question, String>) objects[0];
				int examId = Integer.parseInt((String) objects[1]);

				String hql = "SELECT e FROM ReadyExam e WHERE e.id = :id";
				Query query1 = session.createQuery(hql, ReadyExam.class);
				query1.setParameter("id", examId);
				ReadyExam readyExam = (ReadyExam) query1.getSingleResult();
				readyExam.setOnGoing("no");
				System.out.println("secrets!");
				int sum = 0;
				for (Question q : map.keySet())
				{

					 hql = "SELECT q FROM Question q WHERE q.id = :id";
					Query query2 = session.createQuery(hql, Question.class);
					query2.setParameter("id", q.getId());
					Question question = (Question) query2.getSingleResult();
					System.out.println(q.getQText() + ", answer: " + map.get(q));

					// updating student answer
					question.setStudentAnswer(map.get(q));
					if (question.getCorrectAnswer().equals(question.getStudentAnswer()))
					{
						sum += question.getScore();
						question.setAnsweredCorrectly("yes");
					}
					System.out.println("secrets!!");
					session.update(question);
					session.flush();
					System.out.println("secrets!!!");
				}
				readyExam.setGrade(sum);
				System.out.println("secrets!!!!");
				session.update(readyExam.getExam());
				session.flush();
				System.out.println("secrets!!!!!!");
				session.update(readyExam);
				session.flush();
				System.out.println("secrets!!!!!!!!");
				client.sendToClient(message);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if("SendToPreview".equals(message.getTitle()))
		{

			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				ReadyExam readyExam = (ReadyExam) message.getBody();
				String hql = "SELECT s FROM Student s WHERE s.username = :username";
				Query query1 = session.createQuery(hql, Student.class);
				query1.setParameter("username", readyExam.getExaminee());
				Student student = (Student) query1.getSingleResult();
				Object object = new Object[]{readyExam, student};
				Message message1 = new Message("SendToPreview", object);
				client.sendToClient(message1);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if("approveExam".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Object[] objects = (Object[]) message.getBody();
				int id = (Integer) objects[0];
				int grade = Integer.parseInt((String)objects[1]);
				String teacherComments = (String)objects[2];
				String studentComments = (String) objects[3];

				String hql = "SELECT re FROM ReadyExam re JOIN FETCH re.exam where re.id = :id";
				Query query1 = session.createQuery(hql, ReadyExam.class);
				query1.setParameter("id", id);
				ReadyExam readyExam = (ReadyExam) query1.getSingleResult();
				readyExam.setGrade(grade);
				session.flush();
				readyExam.getExam().setTeacherComments(teacherComments);
				session.flush();
				readyExam.getExam().setStudentComments(studentComments);
				session.update(readyExam.getExam());
				session.flush();
				readyExam.setApproved("yes");
				session.update(readyExam);
				session.flush();
				client.sendToClient(message);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if("viewGradesForStudent".equals(message.getTitle()))
		{

			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Student student = (Student)message.getBody();
				String username = student.getUsername();

				String hql = "SELECT re FROM ReadyExam re JOIN FETCH re.exam where re.examinee = :username and re.approved = 'yes'";
				Query query1 = session.createQuery(hql, ReadyExam.class);
				query1.setParameter("username", username);
				List<ReadyExam> list = (List<ReadyExam>) query1.getResultList();
				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);

			}catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if("showExamsForTeacherCourses".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Object[] objects = (Object[]) message.getBody();
				Course course = (Course) objects[1];
				Teacher teacher = (Teacher) objects[0];
				String username = teacher.getUsername();
				int id = 0;
				if (course != null)
				{
					id = course.getId();
				}
				String hql = "SELECT e FROM Exam e where e.username = :username and e.course.id =: id and e.isClone = 'no'";
				Query query1 = session.createQuery(hql, Exam.class);
				query1.setParameter("username", username);
				query1.setParameter("id", id);
				List<Exam> list = (List<Exam>) query1.getResultList();

				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);

			}catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if("ShowExamsForTeacherSubjects".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Object[] objects = (Object[]) message.getBody();
				Subject subject = (Subject) objects[1];
				Teacher teacher = (Teacher) objects[0];
				String username = teacher.getUsername();
				int id = 0;
				if (subject != null)
				{
					id = subject.getId();
				}
				String hql = "SELECT e FROM Exam e where e.username = :username and e.subject.id =: id and e.isClone = 'no'";
				Query query1 = session.createQuery(hql, Exam.class);
				query1.setParameter("username", username);
				query1.setParameter("id", id);
				List<Exam> list = (List<Exam>) query1.getResultList();

				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);

			}catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if("ShowReadyExamsForViewGradesForTeacher".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Exam exam = (Exam)message.getBody();
				int id = exam.getId();
				String hql = "SELECT re FROM ReadyExam re where re.originalId =: id and re.approved = 'yes' and re.isClone = 'yes'";
				Query query1 = session.createQuery(hql, ReadyExam.class);
				query1.setParameter("id", id);
				List<ReadyExam> list = (List<ReadyExam>) query1.getResultList();

				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);

			}catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
		else if("GetExamsForCoursePrinciple".equals(message.getTitle()))
		{
			Course course = (Course) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				List<Exam> list = getExamsForCourse(course);
				System.out.println("size of list = " + list.size());
				Message resMessage = new Message("getExamsForCoursePrinciple", list);
				client.sendToClient(resMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("GetExamsForStudentPrinciple".equals(message.getTitle()))
		{
			Student student = (Student) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				List<ReadyExam> list = getExamsForStudent(student);
				System.out.println("size of list = " + list.size());
				Message resMessage = new Message("getExamsForStudentPrinciple", list);
				client.sendToClient(resMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if ("getSubjectsForPrincipleExams".equals(message.getTitle()) || "getSubjectsForPrinciple".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Principle principle = (Principle) message.getBody();
				List<Subject> subjects = getSubjectsForPrinciple(principle);
				Message resMessage = new Message(message.getTitle(), subjects);
				client.sendToClient(resMessage);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if ("getTeachersForPrinciple".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Principle principle = (Principle) message.getBody();
				List<Teacher> teachers = getTeachersForPrinciple(principle);
				Message resMessage = new Message(message.getTitle(), teachers);
				client.sendToClient(resMessage);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if ("getCoursesForPrinciple".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Principle principle = (Principle) message.getBody();
				List<Course> courses = getCoursesForPrinciple(principle);
				Message resMessage = new Message(message.getTitle(), courses);
				client.sendToClient(resMessage);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if ("getStudentsForPrinciple".equals(message.getTitle()) || "getStudentsGradesForPrinciple".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Principle principle = (Principle) message.getBody();
				List<Student> students = getStudentsForPrinciple(principle);
				Message resMessage = new Message(message.getTitle(), students);
				client.sendToClient(resMessage);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}

		else if ("getCoursesForSubjectsPrinciple".equals(message.getTitle()) || "GetCoursesForSubjectsPrincipleExams".equals(message.getTitle()) || "getCoursesForSubjects".equals(message.getTitle()) || "getCoursesForSubjectsEQ".equals(message.getTitle()) || "getCoursesForSubjectsExam".equals(message.getTitle()) || "getCourses".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Subject subject = (Subject) message.getBody();
				List<Course> courses = getCoursesForSubject(subject);
				Message resMessage = new Message(message.getTitle(), courses);
				client.sendToClient(resMessage);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("getExamQuestions".equals(message.getTitle()))
		{
			try
			{
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				System.out.println("getExamQuestions");
				ReadyExam exam = (ReadyExam) message.getBody();
				List<Question> list = exam.getExam().getListOfQuestions();
				for (Question l : list)
				{
					System.out.println(l.getQText() + "   score: ");
				}
				Message resMessage = new Message("getExamQuestions", exam);
				client.sendToClient(resMessage);

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if("GetExamsForTeacherPrinciple".equals(message.getTitle()))
		{
			Teacher teacher = (Teacher) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				List<Exam> list = getExamsForTeacher(teacher);
				System.out.println("size of list = " + list.size());
				Message resMessage = new Message(message.getTitle(), list);
				client.sendToClient(resMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("SetOnGoingToTrue".equals(message.getTitle()))
		{
			ReadyExam readyExam = (ReadyExam) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				int id = readyExam.getReadyExamOriginalID();
				readyExam.setOnGoing("yes");
				//System.out.println("size of list = " + list.size());
				//Message resMessage = new Message(message.getTitle(), list);
				session.update(readyExam);
				session.flush();

				String hql = "SELECT re FROM ReadyExam re where re.id =: id";
				Query query1 = session.createQuery(hql, ReadyExam.class);
				query1.setParameter("id", id);
				ReadyExam readyExam1 = (ReadyExam) query1.getSingleResult();

				readyExam1.setNumOfOnGoingExams(readyExam1.getNumOfOnGoingExams()+1);
				session.update(readyExam1);
				session.flush();

				readyExam1.setOnGoing("yes");
				session.update(readyExam1);
				session.flush();

				hql = "SELECT re FROM ReadyExam re where re.username =: username AND re.OnGoing = 'yes' and re.isClone = 'no'";
				Query query3 = session.createQuery(hql, ReadyExam.class);
				query3.setParameter("username", readyExam.getUsername());
				List<ReadyExam> list = (List<ReadyExam>) query3.getResultList();
				Message responseMessage = new Message("refreshTable",list);
				System.out.println(responseMessage.getTitle());
				sendToAllClients(responseMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("SetOnGoingToFalse".equals(message.getTitle()))
		{
			String s = (String) message.getBody();
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				int id = Integer.parseInt(s);
				String hql = "SELECT re FROM ReadyExam re where re.id =: id";
				Query query1 = session.createQuery(hql, ReadyExam.class);
				query1.setParameter("id", id);
				ReadyExam readyExam = (ReadyExam) query1.getSingleResult();
				int id_ori = readyExam.getReadyExamOriginalID();
				readyExam.setOnGoing("no");
				//System.out.println("size of list = " + list.size());
				//Message resMessage = new Message(message.getTitle(), list);
				session.update(readyExam);
				session.flush();

				hql = "SELECT re FROM ReadyExam re where re.id =: id";
				Query query2 = session.createQuery(hql, ReadyExam.class);
				query2.setParameter("id", id_ori);
				ReadyExam readyExam1 = (ReadyExam) query2.getSingleResult();
				readyExam1.setNumOfOnGoingExams(readyExam1.getNumOfOnGoingExams()-1);
				session.update(readyExam1);
				session.flush();
				if (readyExam1.getNumOfOnGoingExams() == 0)
				{
					readyExam1.setOnGoing("no");
					session.update(readyExam1);
					session.flush();
				}

				hql = "SELECT re FROM ReadyExam re where re.username =: username AND re.OnGoing = 'yes' and re.isClone = 'no'";
				Query query3 = session.createQuery(hql, ReadyExam.class);
				query3.setParameter("username", readyExam.getUsername());
				List<ReadyExam> list = (List<ReadyExam>) query3.getResultList();
				Message responseMessage = new Message("refreshTable",list);
				System.out.println(responseMessage.getTitle());
				sendToAllClients(responseMessage);


			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("GetOnGoingExamsForExtraTime".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				String username = (String) message.getBody();
				String hql = "SELECT re FROM ReadyExam re where re.username =: username AND re.OnGoing = 'yes' and re.isClone = 'no'";
				Query query1 = session.createQuery(hql, ReadyExam.class);
				query1.setParameter("username", username);
				List<ReadyExam> list = (List<ReadyExam>) query1.getResultList();
				for (ReadyExam readyExam : list)
				{
					hql = "SELECT re FROM ReadyExam re where re.username =: username AND re.OnGoing = 'yes' and re.isClone = 'yes' and re.readyExamOriginalID =: id";
					Query query2 = session.createQuery(hql, ReadyExam.class);
					query2.setParameter("username", username);
					query2.setParameter("id", readyExam.getReadyExamOriginalID());
					List<ReadyExam> list_clones = (List<ReadyExam>) query2.getResultList();
					readyExam.setNumOfOnGoingExams(list_clones.size());
					session.update(readyExam);
					session.flush();
				}

				Object object = new Object[]{list};
				Message responseMessage = new Message(message.getTitle(), list);
				client.sendToClient(responseMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("AskPrincipleForExtraTime".equals(message.getTitle()))
		{
			try {
				if (session == null || !session.isOpen() || session.getTransaction() == null || !session.getTransaction().isActive()) {
					session = getSessionFactory().openSession();
					session.beginTransaction();
				}
				Object[] objects = (Object[]) message.getBody();
				String timeAmount = (String) objects[0];
				String explanation = (String) objects[1];
				ReadyExam readyExam = (ReadyExam) objects[2];

				String hql = "SELECT re FROM ReadyExam re where re.id = :id and re.OnGoing = 'yes' and re.isClone = 'no'";
				Query query1 = session.createQuery(hql, ReadyExam.class);
				query1.setParameter("id", readyExam.getReadyExamOriginalID());
				ReadyExam readyExam1 = (ReadyExam) query1.getSingleResult();

				ExtraTime extraTime = new ExtraTime(readyExam1, timeAmount, explanation);
				session.save(extraTime);
				session.flush();
				Message responseMessage = new Message("AskPrincipleForExtraTime", message.getBody());
				client.sendToClient(responseMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null && session.isOpen()) {
					session.getTransaction().commit();
					session.close();
				}
			}
		}
		else if("ExtraTimeRequest".equals(message.getTitle()))
		{
		}
//		if ("Get all Students".equals(message.getOperation())) {
//			try {
//
//				session.beginTransaction();
//
//// Fetch the student data from your data source or database
//				List<Student> students = getAllStudentsFromDatabase();
//
//// Create a new Message with the student data and send it back to the client
//				int msgId = 0;
//				Message responseMessage = new Message("Get all Students", students);
//				client.sendToClient(responseMessage);
//				session.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if ("get grades".equals(message.getOperation())) {
//			try {
//
//				session.beginTransaction();
//				Student studentsel = (Student) message.getMessage();
//				int studentId = studentsel.getId();
//				Student student = getStudentFromDatabase(studentId);
//				Message responseMessage = new Message("get grades", student);
//				client.sendToClient(responseMessage);
//				session.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}else if("update".equals(message.getOperation())){
//			try {
//
//
//				session.beginTransaction();
//				Student studentsel =(Student) message.getMessage();
//				int studentId = studentsel.getId();
//				Student student = updateStudentGradeInDatabase(studentId,message.getSubject(), message.getNewScore());
//				Message responseMessage = new Message("update",student);
//				client.sendToClient(responseMessage);
//
//				session.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

	}


	public static SessionFactory getSessionFactory()
	{
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Exam.class);
		configuration.addAnnotatedClass(Question.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Course.class);
		configuration.addAnnotatedClass(ReadyExam.class);
		configuration.addAnnotatedClass(Principle.class);
		configuration.addAnnotatedClass(ExtraTime.class);


		StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		return configuration.buildSessionFactory(serviceRegistry);
	}
	public static List<Student> getAllStudentsFromDatabase() {
		//Session session = sessionFactory.openSession();
//open hibernate session
		session.beginTransaction();
//create criteria builder and criteria query objects to build query
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		query.select(root);
//execute query and retrieve all students
		List<Student> students = session.createQuery(query).getResultList();
//close transaction and session
		session.getTransaction().commit();
		session.close();

		return students;
	}
	public  static Student getStudentFromDatabase(int studentId){
		//Session session = sessionFactory.openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		query.select(root).where(builder.equal(root.get("id"),studentId));
		Student student = session.createQuery(query).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return student;
	}
	public static Student updateStudentGradeInDatabase(int studentId, String subject , int newGrade) {
			//Session session = sessionFactory.openSession();
			 session.beginTransaction();

			 Student student = session.get(Student.class, studentId);
			 if (student != null) {
			 	if(subject.equals("English")){
					 //student.setEnglishScore(newGrade);
				}else if(subject.equals("Math")){
						//student.setMathScore(newGrade);
					}
				 session.update(student);
				 session.getTransaction().commit();
				 System.out.println("Student grade updated successfully.");
				}

			  else {
					 System.out.println("Student with ID " + studentId + " not found in the database.");
 }
			 session.close();
		return student;
	}
}