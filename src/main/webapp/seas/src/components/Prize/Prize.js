import React, {Component} from 'react';
import { Alert, AlertTitle } from '@material-ui/lab';
import {Redirect, withRouter} from "react-router-dom";
import PrizeTable from "./PrizeTable"
import InfoIcon from '@material-ui/icons/Info';
import Consumer from '../ContextAPI/Context'
import axios from 'axios';
import EventsOfLecturer from "../Lecturer/EventsOfLecturer";
import {isLecturer, isOrganizator, isParticipant} from "../../Authentication";

import {
    MDBCard,
    MDBCardImage,
    MDBCardBody,
    MDBCardTitle,
    MDBCardText,
    MDBCardFooter,
    MDBRow,
    MDBCol
  } from 'mdb-react-ui-kit';

  
class Prize extends Component {
    
    
    state = {
        data: [] 
    }


     componentDidMount =  () => {
        this.getAllNonRaffledEvents();
        // try{
        //     // const response = await fetch('https://jsonplaceholder.typicode.com/posts')
        //     // const data = await response.json();
        //     console.log(data)
        //     this.setState({data: data.splice(0,10)})
        // }catch(err){
        //     console.log(err);
        // }
        // const participantUsername = localStorage.getItem('username');
        // console.log(participantUsername);
        // const response = await axios.get(`/allPrize`, {
        //     headers : {
        //         authorization : 'Bearer ' + localStorage.getItem('jwtToken')
        //     }
        // }).catch(err => {
        //     this.props.history.push('/notFound404');
        // });

        // this.setState({
        //     events : response.data
        // })


    }

    getAllNonRaffledEvents = async () =>{
       // const response = await fetch('http://localhost:3000/allPrize')
        // const data = await response.json();
        // console.log(data)
        // this.setState({data: data.splice(0,10)})



        const response = await axios.get(`/allPrize`, {
            headers : {
                 authorization : 'Bearer ' + localStorage.getItem('jwtToken')
            }
        }).catch(err => {
            console.log(err);


            //this.props.history.push('/notFound404');
        });
        
        this.setState({
            data: response.data,
        })

    }


    render() {
        const {data} = this.state;
        return(
           <div>
            <ul>
               {data.map((item) => {
                return <li key={item.name}>{item.name}</li>

               })}

            </ul>

           </div>

        )

    }
}

export default withRouter(Prize);

