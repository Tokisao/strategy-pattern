public class WalkRouteStrategy implements RouteStrategy {
    @Override
    public String buildRoute(String origin, String destination) {
        return "Walking route from " + origin + " to " + destination
                + " via pedestrian paths (shortest distance).";
    }
}