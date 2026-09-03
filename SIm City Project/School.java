import java.awt.Graphics2D;
import java.awt.Color;
public class School extends Building {
    private int students, teachers; 
    //rule (can be changed later): if 200 children in 5 square radious ad school.
    public void school (int x, int y){
        this.students = 300;
        this.teachers = 30; 
    }

    public void setStudents(int X) {
        this.students = X; 
    }

    public void setTeachers(int Y) {
        this.teachers = Y; 
    }

    public int getStudents() {
        return students; 
    }

    public int getTeachers() {
        return teachers; 
    }

    @Override 
    Public int getPopulation() {
        return this.getStudents() + this.getTeachers(); 
    }

    @Override 
     public void build(Graphics2D g2d, int x, int y) {
        g2d.setColor(new Color(128, 0, 128));
        g2d.fillRect((x * 50) + 7, (y * 50) + 7, 35, 35);
    }
}
