/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.KClass;

import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class KClassDirecroty {
    private ArrayList<KClass> classlist;

    public ArrayList<KClass> getClasslist() {
        return classlist;
    }

    public void setClasslist(ArrayList<KClass> classlist) {
        this.classlist = classlist;
    }

    public KClassDirecroty(ArrayList<KClass> classlist) {
        this.classlist = new ArrayList();
    }
    
    public void deleteClass(KClass c){
        classlist.remove(c);
    }
    
    public KClass addClass(String className,String classType, String teaacherName,int capacity, String deadline, String startDate, String endDate){
        KClass kclass = new KClass();
        kclass.setClassName(className);
        kclass.setClassType(classType);
        kclass.setCapacity(capacity);
        kclass.setTeacherName(teaacherName);
        kclass.setDeadline(deadline);
        kclass.setStartDate(startDate);
        kclass.setEndDate(endDate);
        classlist.add(kclass);
        return kclass;
    }
}
