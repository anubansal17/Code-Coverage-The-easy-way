package Find Callers Project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;

public class FindCallers {

	public static void main(String args[]) throws CoreException {
		FindCallers tb = new FindCallers ();
		tb.test2();
	}

	public void test2() throws CoreException {
		String projectName = "Test";
		IJavaProject javaProject = getJavaProject(projectName);
System.out.println(projectName);
		String targetMethodName = "createClient";
		SearchPattern pattern = SearchPattern.createPattern(targetMethodName, IJavaSearchConstants.METHOD,
				IJavaSearchConstants.REFERENCES, SearchPattern.R_CASE_SENSITIVE // <--- ????
		);

		boolean includeReferencedProjects = false;
		IJavaElement[] javaProjects = new IJavaElement[] { javaProject };
		IJavaSearchScope scope = SearchEngine.createJavaSearchScope(javaProjects, includeReferencedProjects); // <---
																												// ????

		SearchRequestor requestor = new SearchRequestor() {
			
			public void beginReporting() {
				System.out.println("begin searching");
			}
			@Override
			public void acceptSearchMatch(SearchMatch match) throws CoreException {
				System.out.println("matched elements = " + match.getElement());
			}
		};
		
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, scope,
				requestor, null);
		System.out.println("result there?");
	}

	private IJavaProject getJavaProject(String projectName) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		if (!project.exists()) {
			project.create(null);
		} else {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		}

		if (!project.isOpen()) {
			project.open(null);
		}

		IJavaProject jproject = JavaCore.create(project);
		jproject.open(null);
		return jproject;
	}

}
