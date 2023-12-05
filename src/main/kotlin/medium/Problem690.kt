package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/employee-importance/
 */
class Problem690 {
    class Employee(var id: Int, var importance: Int, var subordinates: List<Int>)

    fun getImportance(employees: List<Employee?>, id: Int): Int {

        val idToEmployee = employees.associateBy { employee -> employee!!.id }

        val used = mutableSetOf<Employee>()
        fun dfs(employee: Employee?) {
            if (employee == null) return
            if (employee in used) return
            used.add(employee)
            employee.subordinates.forEach { index ->
                dfs(idToEmployee.getValue(index))
            }
        }
        dfs(employees.firstOrNull { it?.id == id })
        return used.sumOf { it.importance }
    }
}
