import React from 'react';
import { About, Description, Image } from './styles';
import styled from 'styled-components';
//Images
import homeImg1 from './Football2023.png';
import { titleAnim, fade, photoAnim } from './animation';
import { motion } from 'framer-motion';
import Wave from './Wave';

const AboutSection = () => {
  return (
    <About>
      <Description>
        <div>
          <motion.div  className="box"
      initial={{ opacity: 0, scale: 0.5 }}
      animate={{ opacity: 1, scale: 1 }}
      transition={{
        duration: 2,
        delay: 1,
        ease: [0, 0.71, 0.2, 1.01]
      }}>
            <motion.h1 className='bigger' variants={titleAnim}>Finding your favorite events</motion.h1>
          </motion.div>
          <motion.div  className="box"
      initial={{ opacity: 0, scale: 0.5 }}
      animate={{ opacity: 1, scale: 1 }}
      transition={{
        duration: 2,
        delay: 1.5,
        ease: [0, 0.71, 0.2, 1.01]
      }}>
            <motion.h2 variants={titleAnim}>
              Tracking your points
            </motion.h2>
          </motion.div>
          <motion.div  className="box"
      initial={{ opacity: 0, scale: 0.5 }}
      animate={{ opacity: 1, scale: 1 }}
      transition={{
        duration: 2,
        delay: 2,
        ease: [0, 0.71, 0.2, 1.01]
      }}>
            <motion.h2 variants={titleAnim}>Collecting your BIG rewards.</motion.h2>
          </motion.div>
        </div>


        <motion.p variants={fade}
        className="box"
        initial={{ opacity: 0, scale: 0.5 }}
        animate={{ opacity: 1, scale: 1 }}
        transition={{
          duration: 2,
          delay: 3,
          ease: [0, 0.71, 0.2, 1.01]
        }}
        >
          Chattahoochee High School invites you to register with [SEAS] School Event Award System.
        </motion.p>
        
        
        
        {/* <motion.button variants={fade}>Contact Us</motion.button> */}
      </Description>
     

      <Image>
        <motion.img variants={photoAnim} src={homeImg1} alt="Football"  className="box"
      initial={{ opacity: 0, scale: 0.5 }}
      animate={{ opacity: 1, scale: 1 }}
      transition={{
        duration: 2,
        delay: 3.5,
        ease: [0, 0.71, 0.2, 1.01]
      }}/>
      </Image>
   
      <Wave />
      
    </About>
  );
};

const Hide = styled.div`
  overflow: hidden;
`;

export default AboutSection;
