package Entity;

import Main.AllLists;

public class RouteOfDriver {

    private BusRoute busRoute;
    private int route ;
    @Override
    public String toString() {
        return "RouteOfDriver{" +
                "busRoute=" + busRoute +
                ", route=" + route +
                '}';
    }

    public RouteOfDriver(BusRoute busRoute, int route) {
        this.busRoute = busRoute;
        this.route = route;
    }

    public BusRoute getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(BusRoute busRoute) {
        this.busRoute = busRoute;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public RouteOfDriver() {
    }




}
