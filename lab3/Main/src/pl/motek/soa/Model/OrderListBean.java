package pl.motek.soa.Model;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Hashtable;

public class OrderListBean {
    private Hashtable<Integer,Integer> list = new Hashtable<>();

    public Hashtable<Integer, Integer> getList() {
        return list;
    }

    public Hashtable<Integer,Integer> getOrders(){
        return list;
    }

    public void addItem(Integer id){
        list.put(id, list.getOrDefault(id,0) + 1);
    }

    public void removeItem(Integer id){
        if(list.get(id) > 1) {
            list.put(id, list.get(id) - 1);
        } else{
            list.remove(id);
        }
    }
}
