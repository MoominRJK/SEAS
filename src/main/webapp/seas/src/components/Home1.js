import React, { useEffect, useState, Component } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import {Redirect, withRouter} from "react-router-dom";
import axios from 'axios';
import {motion, useAnimation} from 'framer-motion'
import { useInView } from 'react-intersection-observer';
import AboutUs from './animation/AboutSection';

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

class Home extends Component {
    state = {
      data : [] 
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
        console.log(err);
    });
    
    this.setState({
        data: response.data.filter(prize => prize.year === 2023) ,
    })

}

 useStyles = makeStyles((theme) => ({
    root: {
      minHeight: '100vh',
      backgroundImage: `url(${process.env.PUBLIC_URL + '/assets/bg1.png'})`,
      backgroundRepeat: 'no-repeat',
      backgroundSize: 'cover',
    },
  }));

  render() {
    const {data} = this.state;

    const {ref, inView} = useInView();
    const animation = useAnimation();

    useEffect(() => {
      if(inView){
        animation.start({
          x : 0,
          transition: {
            type: 'spring', duration: 1, bounce: 0.3
          }
        })
      }
      if(!inView){
        animation.start({x: '-100vw'})
      }
      console.log("use effect hook, inview", inView);
    }, [inView]);

 
    return (
        <>
          <AboutUs/>
          <div ref={ref}>
            <MDBContainer breakpoint="sm mt-5">
            <motion.div className='text-center mt-5 mb-5' 
            whileHover={{scale: 1.3}}
            >
              <h3 className='text-white' >The More Events You Attend, The More Points You Get !</h3>
            </motion.div>

            <motion.div 
            initial={{x: '-100vw'}}
            animate={{x:0}}
            transition={{type: 'spring', duration: 1, bounce: 0.3}}>      
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
            </motion.div>
            </MDBContainer>
          </div>
        </>
      );
  }
} 
export default withRouter(Home);
