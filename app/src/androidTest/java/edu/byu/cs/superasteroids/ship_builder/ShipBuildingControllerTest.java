package edu.byu.cs.superasteroids.ship_builder;

import junit.framework.TestCase;

import java.util.Map;

/**
 * @author Scott Leland Crossen
 */
public class ShipBuildingControllerTest extends TestCase {
    ShipBuildingController controller=new ShipBuildingController();
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testOnViewLoaded() throws Exception {
        controller.onViewLoaded(IShipBuildingView.PartSelectionView.MAIN_BODY);
        assertEquals(IShipBuildingView.PartSelectionView.ENGINE, controller.getArrows().get(IShipBuildingView.ViewDirection.LEFT));
        assertEquals(IShipBuildingView.PartSelectionView.POWER_CORE, controller.getArrows().get(IShipBuildingView.ViewDirection.UP));
        assertEquals(IShipBuildingView.PartSelectionView.CANNON, controller.getArrows().get(IShipBuildingView.ViewDirection.DOWN));
        assertEquals(IShipBuildingView.PartSelectionView.EXTRA_PART, controller.getArrows().get(IShipBuildingView.ViewDirection.RIGHT));
        controller.onViewLoaded(IShipBuildingView.PartSelectionView.ENGINE);
        assertEquals(IShipBuildingView.PartSelectionView.POWER_CORE, controller.getArrows().get(IShipBuildingView.ViewDirection.LEFT));
        assertEquals(IShipBuildingView.PartSelectionView.CANNON, controller.getArrows().get(IShipBuildingView.ViewDirection.UP));
        assertEquals(IShipBuildingView.PartSelectionView.EXTRA_PART, controller.getArrows().get(IShipBuildingView.ViewDirection.DOWN));
        assertEquals(IShipBuildingView.PartSelectionView.MAIN_BODY, controller.getArrows().get(IShipBuildingView.ViewDirection.RIGHT));
        controller.onViewLoaded(IShipBuildingView.PartSelectionView.POWER_CORE);
        assertEquals(IShipBuildingView.PartSelectionView.CANNON, controller.getArrows().get(IShipBuildingView.ViewDirection.LEFT));
        assertEquals(IShipBuildingView.PartSelectionView.EXTRA_PART, controller.getArrows().get(IShipBuildingView.ViewDirection.UP));
        assertEquals(IShipBuildingView.PartSelectionView.MAIN_BODY, controller.getArrows().get(IShipBuildingView.ViewDirection.DOWN));
        assertEquals(IShipBuildingView.PartSelectionView.ENGINE, controller.getArrows().get(IShipBuildingView.ViewDirection.RIGHT));
        controller.onViewLoaded(IShipBuildingView.PartSelectionView.CANNON);
        assertEquals(IShipBuildingView.PartSelectionView.EXTRA_PART, controller.getArrows().get(IShipBuildingView.ViewDirection.LEFT));
        assertEquals(IShipBuildingView.PartSelectionView.MAIN_BODY, controller.getArrows().get(IShipBuildingView.ViewDirection.UP));
        assertEquals(IShipBuildingView.PartSelectionView.ENGINE, controller.getArrows().get(IShipBuildingView.ViewDirection.DOWN));
        assertEquals(IShipBuildingView.PartSelectionView.POWER_CORE, controller.getArrows().get(IShipBuildingView.ViewDirection.RIGHT));
        controller.onViewLoaded(IShipBuildingView.PartSelectionView.EXTRA_PART);
        assertEquals(IShipBuildingView.PartSelectionView.MAIN_BODY, controller.getArrows().get(IShipBuildingView.ViewDirection.LEFT));
        assertEquals(IShipBuildingView.PartSelectionView.ENGINE, controller.getArrows().get(IShipBuildingView.ViewDirection.UP));
        assertEquals(IShipBuildingView.PartSelectionView.POWER_CORE, controller.getArrows().get(IShipBuildingView.ViewDirection.DOWN));
        assertEquals(IShipBuildingView.PartSelectionView.CANNON, controller.getArrows().get(IShipBuildingView.ViewDirection.RIGHT));
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testOnSlideView() throws Exception {
        IShipBuildingView.ViewDirection new_direction;

        IShipBuildingView.ViewDirection direction=IShipBuildingView.ViewDirection.LEFT;
        IShipBuildingView.PartSelectionView state=IShipBuildingView.PartSelectionView.MAIN_BODY;
        controller.onViewLoaded(state);
        Map<IShipBuildingView.ViewDirection, IShipBuildingView.PartSelectionView> arrows=controller.getArrows();
        controller.onSlideView(IShipBuildingView.ViewDirection.UP);
        switch (direction) {
            case UP:
                new_direction = IShipBuildingView.ViewDirection.DOWN;
                break;
            case DOWN:
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
            case LEFT:
                new_direction = IShipBuildingView.ViewDirection.RIGHT;
                break;
            case RIGHT:
                new_direction = IShipBuildingView.ViewDirection.LEFT;
                break;
            default:
                assert false;
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
        }
        assertEquals(arrows.get(new_direction), controller.getState());

        direction=IShipBuildingView.ViewDirection.UP;
        state=IShipBuildingView.PartSelectionView.MAIN_BODY;
        controller.onViewLoaded(state);
        arrows=controller.getArrows();
        controller.onSlideView(IShipBuildingView.ViewDirection.UP);
        switch (direction) {
            case UP:
                new_direction = IShipBuildingView.ViewDirection.DOWN;
                break;
            case DOWN:
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
            case LEFT:
                new_direction = IShipBuildingView.ViewDirection.RIGHT;
                break;
            case RIGHT:
                new_direction = IShipBuildingView.ViewDirection.LEFT;
                break;
            default:
                assert false;
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
        }
        assertEquals(arrows.get(new_direction), controller.getState());

        direction=IShipBuildingView.ViewDirection.RIGHT;
        state=IShipBuildingView.PartSelectionView.MAIN_BODY;
        controller.onViewLoaded(state);
        arrows=controller.getArrows();
        controller.onSlideView(IShipBuildingView.ViewDirection.UP);
        switch (direction) {
            case UP:
                new_direction = IShipBuildingView.ViewDirection.DOWN;
                break;
            case DOWN:
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
            case LEFT:
                new_direction = IShipBuildingView.ViewDirection.RIGHT;
                break;
            case RIGHT:
                new_direction = IShipBuildingView.ViewDirection.LEFT;
                break;
            default:
                assert false;
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
        }
        assertEquals(arrows.get(new_direction), controller.getState());

        direction=IShipBuildingView.ViewDirection.DOWN;
        state=IShipBuildingView.PartSelectionView.MAIN_BODY;
        controller.onViewLoaded(state);
        arrows=controller.getArrows();
        controller.onSlideView(IShipBuildingView.ViewDirection.UP);
        switch (direction) {
            case UP:
                new_direction = IShipBuildingView.ViewDirection.DOWN;
                break;
            case DOWN:
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
            case LEFT:
                new_direction = IShipBuildingView.ViewDirection.RIGHT;
                break;
            case RIGHT:
                new_direction = IShipBuildingView.ViewDirection.LEFT;
                break;
            default:
                assert false;
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
        }
        assertEquals(arrows.get(new_direction), controller.getState());
    }
}
