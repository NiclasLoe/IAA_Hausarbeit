package de.nordakademie.iaa.roommgmt.action;

import com.opensymphony.xwork2.Action;
import de.nordakademie.iaa.roommgmt.model.Room;
import de.nordakademie.iaa.roommgmt.service.RoomService;

import java.util.List;

/**
 * Action that displays the room list.
 * @author Stephan Anft
 */
public class ShowRoomListAction implements Action {

    /** The room service. */
    private RoomService roomService;

    /** List of rooms. */
    private List<Room> rooms;

    @Override
    public String execute() throws Exception {
        rooms = roomService.listRooms();
        return SUCCESS;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }
}
