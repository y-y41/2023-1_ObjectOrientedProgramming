package lab03;

public class Staff {
	private String name, department;
    private int age, workDays, vacationDays;
	
	public Staff(String name, int age) {
        this.name = name;
        this.age = age;
        department = "None";
        workDays = 0;
        vacationDays = 20;
    }

    public Staff(String name, int age, String dp, int wd, int vd) {
        this.name = name;
        this.age = age;
        department = dp;
        workDays = wd;
        vacationDays = vd;
    }

    public String getName() {
        return name;
    }

    public void setCareer(String dp, int wd) {
        department = dp;
        workDays = wd;
    }

    public boolean sameCareer(Staff s) {
        if (department.equals(s.department) && workDays == s.workDays)
            return true;
        else
            return false;
    }

    public String toString() {
        return "Name: "+name+", Age: "+age+", Department: "+department+", workDays: "+workDays+", vacationDays: "+vacationDays+"\n";
    }

    public void vacation(int vd) {
        if (vd > vacationDays) {
            System.out.printf("%s, 남은 휴가 일 수 부족.\n", name);
        }
        else {
            vacationDays = vacationDays - vd;
            System.out.printf("%s, 휴가 %d 사용. 남은 휴가 일수: %d\n", name, vd, vacationDays);
        }
    }
}
