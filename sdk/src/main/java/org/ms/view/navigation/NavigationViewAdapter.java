package org.ms.view.navigation;

import java.util.ArrayList;
import java.util.List;

public class NavigationViewAdapter {

    private List<NavigationViewItem> datas;

    public NavigationViewAdapter(List<NavigationViewItem> datas) {
        this.datas = datas;
    }

    public List<NavigationViewItem> getDatas() {
        return datas;
    }


    private INavigationViewDataChange dataChange;

    protected void setDataChange(INavigationViewDataChange dataChange) {
        this.dataChange = dataChange;
    }

    public void notificationDataChange() {
        if (dataChange != null) {
            dataChange.notificationDataChange();
        }
    }

    interface INavigationViewDataChange {
        void notificationDataChange();
    }
}
