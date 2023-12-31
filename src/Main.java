import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Test Case 1
        List<Project> projects1 = new ArrayList<>();
        projects1.add(new Project(1, 50, 2));
        projects1.add(new Project(2, 10, 1));
        projects1.add(new Project(3, 20, 2));
        projects1.add(new Project(4, 30, 1));

        ResourceAllocator allocator1 = new ResourceAllocator();

        //Testing Descending Sorter by Project Profit
        /*System.out.println(projects1.get(0).getProfit() + " " + projects1.get(1).getProfit() + " " + projects1.get(2).getProfit() + " " + projects1.get(3).getProfit());
        List<Project> projects2 = allocator1.insertionSortDescending(projects1);
        System.out.println(projects2.get(0).getProfit() + " " + projects2.get(1).getProfit() + " " + projects2.get(2).getProfit() + " " + projects2.get(3).getProfit());*/

        System.out.println("Test Case 1: " + allocator1.maxProfit(projects1, 2));

        // Test Case 2
        List<Project> projects2 = new ArrayList<>();
        projects2.add(new Project(1, 30, 1));
        projects2.add(new Project(2, 20, 2));
        projects2.add(new Project(3, 10, 3));

        ResourceAllocator allocator2 = new ResourceAllocator();
        System.out.println("Test Case 2: " + allocator2.maxProfit(projects2, 1));

        // Test Case 3
        List<Project> projects3 = new ArrayList<>();
        projects3.add(new Project(1, 40, 1));
        projects3.add(new Project(2, 20, 2));
        projects3.add(new Project(3, 10, 3));
        projects3.add(new Project(4, 30, 1));
        projects3.add(new Project(5, 70, 1));
        projects3.add(new Project(6, 60, 1));

        ResourceAllocator allocator3 = new ResourceAllocator();
        System.out.println("Test Case 3: " + allocator3.maxProfit(projects3, 2));

        //Test 4
        List<Project> projects4 = new ArrayList<>();
        projects4.add(new Project(1, 10, 1));
        projects4.add(new Project(2, 20, 1));
        projects4.add(new Project(3, 60, 4));
        projects4.add(new Project(4, 40, 3));
        projects4.add(new Project(5, 50, 1));
        projects4.add(new Project(6, 90, 1));

        ResourceAllocator allocator4 = new ResourceAllocator();
        System.out.println("Test Case 4: " + allocator4.maxProfit(projects4, 2));

        //Test 5
        List<Project> projects5 = new ArrayList<>();
        projects5.add(new Project(1, 10, 6));
        projects5.add(new Project(2, 20, 6));
        projects5.add(new Project(3, 60, 6));
        projects5.add(new Project(4, 40, 6));
        projects5.add(new Project(5, 50, 6));
        projects5.add(new Project(6, 90, 6));

        ResourceAllocator allocator5 = new ResourceAllocator();
        System.out.println("Test Case 5: " + allocator5.maxProfit(projects5, 1));


    }
}