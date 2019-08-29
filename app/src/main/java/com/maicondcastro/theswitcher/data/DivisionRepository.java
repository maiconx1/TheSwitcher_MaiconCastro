package com.maicondcastro.theswitcher.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.databinding.ObservableArrayList;

import com.maicondcastro.theswitcher.model.Division;
import com.maicondcastro.theswitcher.model.DivisionDao;

public class DivisionRepository {

    private DivisionDao divisionDao;

    private ObservableArrayList<Division> divisions = new ObservableArrayList<>();

    public DivisionRepository(Application application) {
        Database db = Database.getInstance(application.getApplicationContext());
        divisionDao = db.divisionDao();
        divisions.addAll(divisionDao.getDivisions());
    }

    public void insert(Division division) {
        new AsyncDb(divisionDao, division).execute(AsyncDb.INSERT);
    }

    public void update(Division division) {
        new AsyncDb(divisionDao, division).execute(AsyncDb.UPDATE);
    }

    public void delete(Division division) {
        new AsyncDb(divisionDao, division).execute(AsyncDb.DELETE);
    }

    public ObservableArrayList<Division> getDivisions() {
        return divisions;
    }

    private class AsyncDb extends AsyncTask<Integer, Integer, Integer> {

        static final int INSERT = 0, UPDATE = 1, DELETE = 2;
        private Division division;
        private DivisionDao dao;

        AsyncDb(DivisionDao dao, Division division) {
            this.dao = dao;
            this.division = division;
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            if(integers.length > 0) {
                switch (integers[0]) {
                    case INSERT:
                        dao.insert(division);
                        divisions.add(division);
                        break;
                    case UPDATE:
                        dao.update(division);
                        divisions.set(divisions.indexOf(division), division);
                        break;
                    case DELETE:
                        dao.delete(division);
                        divisions.remove(division);
                        break;
                }
            }
            return null;
        }
    }
}
