import React, {Component} from 'react';
import {withRouter} from "react-router-dom";

class UserGuide extends Component {
    state = {
        informationMessageAboutEvent : '',
        isJoinedBefore: false,

    }

    render() {
        const{isJoinedBefore} = this.state;
        return (
            <div>
               

               
            </div>
        );
    }
}

export default withRouter(UserGuide);

