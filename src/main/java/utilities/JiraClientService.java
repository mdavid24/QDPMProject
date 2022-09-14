package utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraClientService {

	public JiraClient Jclient;
	public String project;
	
	public JiraClientService(String jiraurl,String username,String password,String project) 
	
	{
		BasicCredentials creden = new BasicCredentials(username, password);
		
		Jclient = new JiraClient(jiraurl, creden);
		this.project=project;
		
		
	}
	
	
	public void createJiraTicket(String issuetype,String summary,String description,String priority,String assigneename,File screenshot) throws JiraException
	{
//		List<File> flist = new ArrayList<>();
//		flist.add(screenshot);
		FluentCreate  fluent =  Jclient.createIssue(project, issuetype);
		fluent.field(Field.SUMMARY,summary);
		fluent.field(Field.DESCRIPTION,description);
		fluent.field(Field.PRIORITY,priority);
		fluent.field(Field.ASSIGNEE,assigneename);
		//fluent.field(Field.ATTACHMENT,flist.);
	Issue newissue =	fluent.execute();
	
	newissue.addAttachment(screenshot);
	System.out.println("New Issue is Created with ID : "+newissue);
	}
	
}
