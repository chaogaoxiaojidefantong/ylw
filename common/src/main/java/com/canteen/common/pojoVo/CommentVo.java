package com.canteen.common.pojoVo;

import com.canteen.common.pojo.Comment;
import com.canteen.common.pojo.Ord;
import com.canteen.common.pojo.User;

public class CommentVo extends Comment {
    private User user;

    private Ord order;

    public Ord getOrder() {
        return order;
    }

    public void setOrder(Ord order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
