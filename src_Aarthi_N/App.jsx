import { PlayerList } from "./PlayerList";


import {BrowserRouter,Routes,Route,Link} from 'react-router-dom'
import { AddPlayer } from "./AddPlayer";
import { UpdatePlayer } from "./UpdatePlayer";
import { NotFound } from "./NotFound";
import { DisplayByTeam } from "./DisplayByTeam";
export function  App(props){

  

        return (


                 <>
                       <h1>Cricket management system</h1>
               
          
                    <BrowserRouter>
                    <nav>
                     
                          
          
                        <button><Link to="/">List of players</Link></button>
                        
                       
                            
                    </nav>
                    <Routes>
                      
                        <Route path="/" element={<PlayerList/>} ></Route>
                        <Route path="/addplayers" element={<AddPlayer/>}></Route>
                        <Route path="/edit/:id" element={<UpdatePlayer/>}></Route>
                        <Route path="/searchByName" element={<DisplayByTeam/>} />
                        <Route path="*" element={<NotFound/>}></Route>
                        
                    </Routes>
                    </BrowserRouter>


                  
                
                
                </>



        )

}
