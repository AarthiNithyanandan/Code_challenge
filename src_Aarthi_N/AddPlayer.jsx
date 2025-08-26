import { useState,useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { PlayerService } from "./PlayerService";
export const AddPlayer=()=>{
    const navigate = useNavigate();

    const [player, setPlayer] = useState({
        playerName: "",
        jerseyNumber: "",
        role: "",
        totalMatches: "",
        teamName: "",
        countryName: "",
        description: ""
    });

    const [errors, setErrors] = useState({});

     const handleChange = (e) => {
    const { name, value } = e.target;
    setPlayer({ ...player, [name]: value });
    setErrors({...errors,[name]:" "})
  };


  const validate = () => {
    let err = {};
    if (!player.playerName) 
    err.playerName = "Player Name is required";
    if (!player.jerseyNumber) 
    err.jerseyNumber = "Jersey Number is required";
    if (!player.role)
     err.role = "Role is required";
    if (!player.teamName) 
    err.teamName = "Team Name is required";
    if (!player.countryName)
     err.countryName = "Country Name is required";
    setErrors(err);
    return Object.keys(err).length === 0;
  };

 const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validate()) return;

    try {
      await PlayerService.create(player);
      navigate("/");
    } catch (err) {
      console.error(err);
    }
  };

return(
    
     <div className="container mt-3">
       
            <h2>Add Player</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label>Player Name</label>
                    <input type="text" name="playerName" value={player.playerName} onChange={handleChange} className="form-control"
                    />
                    {errors.playerName}
                   
                </div>

                <div className="mb-3">
                    <label>Jersey Number</label>
                    <input type="number"  name="jerseyNumber" value={player.jerseyNumber} onChange={handleChange} className="form-control"
                    />
                    {errors.jerseyNumber}
                
                </div>

                <div className="mb-3">
                    <label>Role</label>
                    <select name="role" value={player.role} onChange={handleChange} className="form-control"
                    >
                        <option value="">Select Role</option>
                       <option value="Batsman">Batsman</option>
                      <option value="All Rounder">Player</option>
                      <option value="Bowler">Bowler</option>
                    </select>
                   {errors.role}
                </div>

                <div className="mb-3">
                    <label>Total Matches</label>
                    <input type="number" name="totalMatches" value={player.totalMatches} onChange={handleChange} className="form-control"
                    />
                    {errors.totalMatches}
                </div>

                <div className="mb-3">
                    <label>Team Name</label>
                     <select name="teamName" value={player.teamName} onChange={handleChange} className="form-select mb-2" required>
          <option value="">Select Team</option>
          <option value="Africa">Africa</option>
          <option value="India">India</option>
          <option value="Australia">Australia</option>
          <option value="New Zealand">New Zealand</option>
          <option value="Sri lanka">Sri lanka</option>
        </select>
                   {errors.teamName}
                </div>

                <div className="mb-3">
                    <label>Country Name</label>
                    <input type="text" name="countryName" value={player.countryName} onChange={handleChange} className="form-control"
                    />
                  {errors.countryName}
                </div>

                <div className="mb-3">
                    <label>Description</label>
                    <textarea name="description" value={player.description} onChange={handleChange} className="form-control" maxLength="500"
                    />
                   {errors.description}
                </div>

                <button className="btn btn-success" type="submit">Add Player</button>
            </form>
        </div>
)
}