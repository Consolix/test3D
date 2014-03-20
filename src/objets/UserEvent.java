package objets;

import org.lwjgl.input.Mouse;

public class UserEvent {
    private TrackBallCamera camera;
    @SuppressWarnings("unused")
	private Terre planete;
    
    public UserEvent(TrackBallCamera camera, Terre planete) {
        this.camera = camera;
        this.planete = planete;
    }
    
    public void traiterEvents() {
        while (Mouse.next()) {
            this.camera.onMouseMotion();
        }
    }
}
