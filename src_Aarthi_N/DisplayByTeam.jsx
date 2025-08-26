import { useState, useEffect } from "react";
import { PlayerService } from "./PlayerService";

export const DisplayByTeam = () => {
  const [players, setPlayers] = useState([]);
  const [searchTeam, setSearchTeam] = useState("");

  const fetchAllPlayers = async () => {
    try {
      const res = await PlayerService.getAll();
      setPlayers(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const fetchPlayersByTeam = async (team) => {
    if (!team) {
      fetchAllPlayers();
      return;
    }
    try {
      const res = await PlayerService.searchByTeam(team);
      setPlayers(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchAllPlayers();
  }, []);

  return (
    <div className="container mt-3">
      <h2>Players List</h2>

      {/* Search input */}
      <div className="mb-3">
        <input
          type="text"
          placeholder="Search by Team Name"
          className="form-control"
          value={searchTeam}
          onChange={(e) => {
            setSearchTeam(e.target.value);
            fetchPlayersByTeam(e.target.value);
          }}
        />
      </div>

      {/* Players table */}
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Player Name</th>
            <th>Jersey Number</th>
            <th>Role</th>
            <th>Team Name</th>
            <th>Country</th>
          </tr>
        </thead>
        <tbody>
          {players.map((p) => (
            <tr key={p.playerId}>
              <td>{p.playerName}</td>
              <td>{p.jerseyNumber}</td>
              <td>{p.role}</td>
              <td>{p.teamName}</td>
              <td>{p.countryName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
