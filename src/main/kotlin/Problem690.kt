/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/employee-importance/
 */
class Problem690 {
    class Employee(id: Int, importance: Int, subordinates: List<Int>) {
        var id = id
        var importance = importance
        var subordinates: List<Int> = subordinates
    }

    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val used = mutableSetOf<Employee>()
        fun dfs(employee: Employee?) {
            if (employee == null) return
            if (employee in used) return
            used.add(employee)
            employee.subordinates.forEach { index ->
                dfs(employees.firstOrNull { it?.id == index })
            }
        }
        dfs(employees.firstOrNull { it?.id == id })
        return used.map { it.importance }.sum()
    }
}
