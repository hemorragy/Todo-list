package com.example.lois.todo_list;

/**
 * Created by lois on 31/01/2018.
 */

public class Task {

    private String _name;
    private String _desc;
    private int _id;
    private String _prio;
    private String _date;

    Task(String _name, String _desc, int _id, String _prio, String _date) {
        this._name = _name;
        this._desc = _desc;
        this._id = _id;
        this._prio = _prio;
        this._date = _date;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_prio() {
        return _prio;
    }

    public void set_prio(String _prio) {
        this._prio = _prio;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }
}
