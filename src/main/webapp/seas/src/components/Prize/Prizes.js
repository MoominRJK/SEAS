import React, {Component} from 'react';
import { Alert, AlertTitle } from '@material-ui/lab';
import {Redirect, withRouter} from "react-router-dom";
import PrizeTable from "./PrizeTable"
import InfoIcon from '@material-ui/icons/Info';
import Consumer from '../ContextAPI/Context'
import axios from 'axios';
import EventsOfLecturer from "../Lecturer/EventsOfLecturer";
import {isLecturer, isOrganizator, isParticipant} from "../../Authentication";
import {Card, Form, Button, Col, InputGroup} from 'react-bootstrap';
import Collapse from 'react-bootstrap/Collapse';

import {
    MDBCard,
    MDBCardImage,
    MDBCardBody,
    MDBCardTitle,
    MDBCardText,
    MDBCardFooter,
    MDBRow,
    MDBCol,
    MDBContainer,
    MDBBadge,

  } from 'mdb-react-ui-kit';

  
class Prizes extends Component {
    
    
    state = {

        events : [],
        participants : [],
        selectedEventName : '',
        isBackDropOpen : false,
        message  : '',
        messageType : '',
        isMessageBoxOpen: false,
        nonRaffledEvents : [],
        userType : '',
        userType1 : '',
        saveReocrd : false,
        pp: [],
        columns: [
            { title: 'First Name', field: 'firstName' },
            { title: 'Last Name', field: 'lastName' },
            { title: 'Grade', field: 'grade'},
            {title : 'Total Points', field : 'totalPoint'},
        ],
        doShow: false,
        data : [],
        show: false,
        name: '',
        category: '0',
        awardType: '0',
        year : 0,
        quarter : 0,
        grade : 0
       
    }

    toggle = () => this.setState((currentState) => ({show: !currentState.show}));

    changeEventNameWith = (val) =>{
        this.setState({
            selectedEventName : val
        })
    }

    componentDidMount =  () => {
        this.getAllPrizes();
    }

    getAllPrizes = async () =>{

       
        const response = await axios.get(`/allPrize`, {
            headers : {
                 authorization : 'Bearer ' + localStorage.getItem('jwtToken')
            }
        }).catch(err => {
            this.props.history.push('/notFound404');
        });
        
        this.setState({
            data: response.data,
        })
    }

    loadSearchedPrizes = async () =>{
         const {name, category, awardType, year, quarter, grade}  = this.state;
        const response = await axios.get(`/filterPrize/${category}/${awardType}/${year}/${quarter}/${grade}`, {
            headers : {
                authorization : 'Bearer ' + localStorage.getItem('jwtToken')
            }
        }).catch(err => {
            this.props.history.push('/notFound404');
        });
        this.setState({
            data : response.data,
            
        })
    }


    handleEventCategoryChange = (e) => {
        e.preventDefault();
        this.setState({
            category : e.target.value,
        }, this.loadSearchedPrizes)
    }

    handleEventAwardTypeChange = (e) => {
        e.preventDefault();
        this.setState({
            awardType : e.target.value,
        }, this.loadSearchedPrizes)
    }


    handleYearChange  = (e) => {
        e.preventDefault();
        this.setState({
            year : e.target.value,
        }, this.loadSearchedPrizes)
    }

    handleQuarterChange  = (e) => {
        e.preventDefault();
        this.setState({
            quarter : e.target.value,
        }, this.loadSearchedPrizes)
    }
    
    

    handleGradeChange  = (e) => {
        e.preventDefault();
        this.setState({
            grade : e.target.value,
        }, this.loadSearchedPrizes)
    }


    render() {
        return(<Consumer>
                {
                    value => {
                        const {data} = this.state;
                        return (
                            <div className={"mt-1"}>
                                     <div  className={"mt-1 text-right mr-5"} >
                                    <a  aria-controls="example-collapse-text"
                                          aria-expanded={this.state.show} className='text-white' href="#" role="button" onClick={this.toggle}>
                                     Advanced Search
                                    </a>    
                                   
                                    <Collapse in={this.state.show}>
                                          <div id="example-collapse-text">
                                    <Form >
                                        <Card.Body>
                                            <Form.Row className={"mt-1 mr-5 text-white text-left"}>
                                                <Form.Group as={Col} controlId="formGridName">
                                                    <Form.Label>Search</Form.Label>
                                                    <InputGroup>
                                                        <Form.Control required autoComplete="off"
                                                                      type="text" name="name"
                                                                      value={this.state.name} onChange={(e) => this.changeInput(e)}
                                                                      placeholder="Prize Name" />
                                                    </InputGroup>
                                                </Form.Group>
                                                <Form.Group as={Col} controlId="formGridType">
                                                    <Form.Label>Prize Category</Form.Label>
                                                    <InputGroup>
                                                        <Form.Control as="select" required
                                                            value={this.state.category}
                                                            onChange={(e) => this.handleEventCategoryChange(e)}>
                                                            <option value="0"> Select All </option>
                                                            <option value="Food Reward">Food Reward</option>
                                                            <option value="Privilege Reward">Privilege Reward</option>
                                                            <option value="School Reward">School Reward</option>
                                                            <option value="Spirit Reward">Spirit Reward</option>
                                                            
                                                        </Form.Control>
                                                    </InputGroup>
                                                    
                                                </Form.Group>

                                                <Form.Group as={Col} controlId="formGridType">
                                                    <Form.Label>Award Type</Form.Label>
                                                    <InputGroup>
                                                        <Form.Control as="select" required
                                                            value={this.state.awardType}
                                                            onChange={(e) => this.handleEventAwardTypeChange(e)}>
                                                            <option value="0"> Select All </option>
                                                            <option value="Raffle">Raffle Award</option>
                                                            <option value="Top">Top Point Accumulator</option>
                                                         
                                                        </Form.Control>
                                                    </InputGroup>
                                                    
                                                </Form.Group>

                                            </Form.Row>

                                        <Form.Row className={"mt-1 mr-5 text-white text-left"}>
                                            <Form.Group as={Col} controlId="formGridType">
                                                    <Form.Label>Year</Form.Label>
                                                    <InputGroup>
                                                        <Form.Control as="select" required
                                                            value={this.state.year}
                                                            onChange={(e) => this.handleYearChange(e)}>
                                                            <option value="0"> Select All </option>
                                                            <option value="2022">2022</option>
                                                            <option value="2023">2023</option>
                                                           
                                                            
                                                        </Form.Control>
                                                    </InputGroup>
                                                    
                                                </Form.Group>
                                                <Form.Group as={Col} controlId="formGridType">
                                                    <Form.Label>Quarter</Form.Label>
                                                    <InputGroup>
                                                        <Form.Control as="select" required
                                                            value={this.state.quarter}
                                                            onChange={(e) => this.handleQuarterChange(e)}>
                                                            <option value="0"> Select All </option>
                                                            <option value="1">1st Quarter</option>
                                                            <option value="2">2nd Quarter</option>
                                                            <option value="3">3rd Quarter</option>
                                                            <option value="4">4th Quarter</option>
                                                            
                                                        </Form.Control>
                                                    </InputGroup>
                                                    
                                                </Form.Group>

                                                <Form.Group as={Col} controlId="formGridType">
                                                    <Form.Label>Grade</Form.Label>
                                                    <InputGroup>
                                                        <Form.Control as="select" required
                                                            value={this.state.eventType}
                                                            onChange={(e) => this.handleGradeChange(e)}>
                                                            <option value="0"> Select All </option>
                                                            <option value="9">9 Grade</option>
                                                            <option value="10">10 Grade</option>
                                                            <option value="11">11 Grade</option>
                                                            <option value="12">12 Grade</option>
                                                         
                                                        </Form.Control>
                                                    </InputGroup>
                                                    
                                                </Form.Group>

                                            </Form.Row>
                                            </Card.Body>
                                            {/* <Card.Footer style={{"textAlign":"right"}}
                                                     className={"d-flex justify-content-between"}>
                                            <div >
                                            
                                            </div>
                                            <Button  variant="success" type="submit">
                                            submit
                                            </Button>
                                        </Card.Footer> */}
                                    </Form>
                                    </div>
                                    </Collapse>
                                 
                                </div>

                                        <MDBContainer breakpoint="sm mt-1">
                                            <div className='text-center' >
                                            <h1 className='text-white'>All Prizes</h1>
                                            </div>
                                        
                                            <MDBRow className='row-cols-1 row-cols-md-4 g-4'>
                                                {data.map((item) => (
                                            
                                                        <MDBCol className='mb-2'>
                                                            <MDBCard className='h-100'>
                                                            <MDBCardImage
                                                                src={`${process.env.PUBLIC_URL}/assets/prize/${item.imageUrl}`} 
                                                                alt='...'
                                                                position='top'
                                                            />
                                                            <MDBCardBody>
                                                                <MDBCardTitle>{item.name}</MDBCardTitle>
                                                                <MDBCardText>
                                                                {item.description}
                                                                </MDBCardText>
                                                           
                                                            </MDBCardBody>
                                                            <p className='fw-bold mb-1'>
                                                                <MDBBadge pill light className= 'ml-4 ms-2 center' color='warning'>
                                                                            {item.type}
                                                                        </MDBBadge></p>
                                                            <MDBCardFooter className={`${item.awardType === "Top" ? 'bg-success shadow-1-strong': 'bg-primary shadow-1-strong'} `}>
                                                                <h6 className= 'text-white text-center'>{item.grade}th Grade: <br/>{item.awardType === "Top" ? 'Top Accumulator Prize' : 'Raffle Prize'}</h6>

                                                                <h6 className= 'text-white text-center'>{item.year} : {item.quarter} Quarter</h6>

                                                            </MDBCardFooter>
                                                            </MDBCard>
                                                        </MDBCol>
                                      
                                             
                                             ))}
                                                                                
                                            </MDBRow>
                                        </ MDBContainer>
{/* 
                                {isParticipant() ?
                                      <div className={"mt-5"}>
                                          <Alert severity="info" className={"container"}>
                                                <AlertTitle>Information</AlertTitle>
                                                to the left of the event name. <InfoIcon></InfoIcon>
                                                <strong>by pressing the icon
                                                    get information about the event and
                                                    you can attend the event.</strong>
                                        </Alert>
                                      </div> : null }
                                {isOrganizator() ?
                                    <div className={"mt-5"}>
                                        <Alert severity="info" className={"container"}>
                                            <AlertTitle>Information</AlertTitle>
                                            to the left of the event name. <InfoIcon></InfoIcon>
                                            <strong>by pressing the icon
                                                get information about the event,
                                                You can create a poll and view the participants of the event.
                                                you can view.</strong>
                                        </Alert>
                                    </div>
                                    : null} */}
                            </div>
                        );
                    }
                }
            </Consumer>
        )

    }
}

export default withRouter(Prizes);

