import java.util.List;

public class ResourceAllocator {
    public int maxProfit(List<Project> projects, int workers){
        //First, we sort the projects in descending order in regard to their profits
        List<Project> sortedProjects = insertionSortDescending(projects);
        //Secondly, we find the max deadline (e.g 0,1,3,4) that represent the max amount of days a customer/project is willing to wait
        int maxDeadline = 0;
        for(Project project : sortedProjects){
            if(project.getDeadline() > maxDeadline){
                maxDeadline = project.getDeadline();
            }
        }
        //Thirdly, we create a 2D array with rows the same number as workers
        //and with columns the same number as the max deadline
        Integer[][] table = new Integer[workers][maxDeadline];
        //Fourthly, we assign the projects into each array cell.
        //a project inside row 0, column 0 is assigned to worker 1 day 1
        //a project inside row 1, column 0 is assigned to worker 2 day 1 and so on
        //since the projects are already sorted, once we assign a project in the first cell,
        //we should not replace the project with any other project
        //if there exists more projects with the same number of deadlines than workers,
        //then we try to add the project to the previous day of the deadline day if applicable
        //Important: a project with deadline 3 will be assigned to a worker's 3rd day;
        //this optimizes the solution because it allows other more urgent projects to be done earlier
        for(Project project : sortedProjects) {
            boolean projectAssigned = false;
            for(int row = 0; row < workers; row++) {
                if(table[row][project.getDeadline() - 1] == null && projectAssigned == false) {
                    table[row][project.getDeadline() - 1] = project.getId();
                    projectAssigned = true;
                }
            }
            for(int row = 0; row < workers; row++) {
                for(int column = project.getDeadline(); column > 0; column--) {
                    if(table[row][column - 1] == null && projectAssigned == false) {
                        table[row][column - 1] = project.getId();
                        projectAssigned = true;
                    }
                }
            }

        }
        //Finally, we iterate through all nonempty cells of the table and sum up the projects' profits
        //By this time, we will have chosen the projects with the highest amount of profit only
        //that will be assigned to the optimal days
        int maxProfit = 0;
        for(int row =0; row  < workers; row++){
            for(int column=0; column < maxDeadline; column++){
                if(table[row][column] != null){
                    int projectId = table[row][column];
                    maxProfit = maxProfit + findProjectProfit(sortedProjects, projectId);
                }
            }
        }
        return maxProfit;
    }
    //The following method is used to find a project's profit
    public int findProjectProfit(List<Project> projects, int projectId){
        for(Project project : projects){
            if(project.getId() == projectId){
                return project.getProfit();
            }
        }
        return 0;
    }
    //Insertion Sort Descending Version by project profit
    public List<Project> insertionSortDescending(List<Project> arr) {
        for (int i = 1; i < arr.size(); i++) {
            Project valueToSort = arr.get(i);
            int j = i;
            while (j > 0 && arr.get(j - 1).getProfit() < valueToSort.getProfit()) {
                arr.set(j, arr.get(j-1));
                j--;
            }
            arr.set(j, valueToSort);
        }
        return arr;
    }
}
