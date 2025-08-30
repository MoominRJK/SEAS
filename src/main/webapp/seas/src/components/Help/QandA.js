import React, {Component} from 'react';
import {withRouter} from "react-router-dom";

class QandA extends Component {
    state = {
        informationMessageAboutEvent : '',
        isJoinedBefore: false,

    }

    render() {
        const{isJoinedBefore} = this.state;
        return (
            <div>

<h3 class="card-title d-flex  justify-content-center font-weight-bold text-white mt-5 ml-5">Questions and Answers</h3>
<div class="d-flex justify-content-center border-light p-5">
{/* <div class="d-flex justify-content-center border bg-white border-light p-5"></div> */}
    <section class="mb-4 text-white">


      <h2 class="h2-responsive text-white text-center my-4">Ask a question</h2>

      <p class="text-center w-responsive mx-auto mb-5">Do you have any questions? Please do not hesitate to ask them. 
        The SEAS community will help you find the answers that you are looking for.</p>

              <form id="contact-form" name="contact-form" action="mail.php" method="POST">

              
                  <div class="row">
                                            <div class="col-md-12">
                                                <div class="md-form mb-0">
                                                <label for="subject" class="">Title</label>
                                                    <input type="text" id="subject" name="subject" class="form-control" />
                                                    
                                                </div>
                                            </div>
                                        </div>
                                        

                                    
                                        <div class="row">

                                            
                                            <div class="col-md-12">

                                                <div class="md-form">
                                                <label for="message">Your question</label>
                                                    <textarea type="text" id="message" name="message" rows="5" class="form-control md-textarea"></textarea>
                                                   
                                                </div>

                                            </div>
                                        </div>
                                    

                                    </form>

                                    <div class="text-center text-md-left text-white mt-2">
                                        <a class="btn btn-primary" onclick="document.getElementById('contact-form').submit();">Ask Your Question</a>
                                    </div>
                                    <div class="status"></div>
                            
                            

                            </section>
                            
                        </div>

                        <main class="mt-0 pt-4">
                             <div class="container dark-grey-text mb-5">
                                        <div class="card">
                                                <div class="card-header bg- ">Q: Will the event tickets sent to my email address directly? <br/>
                                                I don't have the phone handy to take the event tickets on the screen. That is why I am asking.
                                                <a class="d-flex flex-row-reverse" href="#"><img style={{width: "1.5em", height: "1.5em", "vertcal-align":  "-.125em", }} src={`${process.env.PUBLIC_URL}/assets/reply.png`} /></a>
                                                </div>
                                                        <div class="card-body bg-success">
                                                            ANS: Yes, the event tickect will be sent to your email address. You can print them out and just bring the phone and show it to the event stuffs.       
                                                        </div>
                                        </div>
                                </div>
                                                

                            <div class="container dark-grey-text mb-5">
                                <div class="card">
                                    <div class="card-header bg- ">Q: If ther are more than one top point accumulator, how do you decide who is the winner? <br/>
                                    Do both of us get the prize too?
                                    <a class="d-flex flex-row-reverse" href="#"><img style={{width: "1.5em", height: "1.5em", "vertcal-align":  "-.125em", }}src={`${process.env.PUBLIC_URL}/assets/reply.png`} /></a>
                                    </div>
                                            <div class="card-body bg-success">
                                                ANS: If there are more than one top point accumulator, the system will randomly pick one winner.  
                                                
                                            </div>
                                    
                                </div>
                            </div>
                              
                        </main>



               
            </div>
        );
    }
}

export default withRouter(QandA);

