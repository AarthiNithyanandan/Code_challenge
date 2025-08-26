
import axios from "axios";
import { useState,useEffect } from "react";
import { Link } from "react-router-dom";
import { PlayerService } from "./PlayerService";

export const PlayerList=()=>{

    const [players,setPlayers]=useState([]);

      

    async function getPlayers() {
        const res = await  PlayerService.getAll()
        setPlayers(res.data);
    };

    useEffect(() => {
        getPlayers();
    }, []);


    return<>
      <button><Link to="/addplayers">Add Player</Link></button>
     <table className="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Jersey Number</th>
                        <th>Role</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {players.map(player => (
                        <tr key={player.playerId}>
                            <td>{player.playerId}</td>
                <td>{player.playerName}</td>
                <td>{player.jerseyNumber}</td>
                     <td>{player.role}</td>
                            <td>
                               <button><Link to={`/edit/${player.playerId}`} className="btn btn-warning ">Edit</Link></button> 
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>


    </>
}