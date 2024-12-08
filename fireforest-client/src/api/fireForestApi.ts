import axios, { AxiosResponse } from "axios";
import { Grid } from '@/types/CellState';

const API_BASE_URL = "http://localhost:8080/api/v1/simulation";

export const fireForestApi = {
  async initializeForest(): Promise<Grid> {
    const response: AxiosResponse<Grid> = await axios.get(`${API_BASE_URL}/initialize`);
    return response.data;
  },

  async simulateStep(): Promise<Grid> {
    const response: AxiosResponse<Grid> = await axios.post(`${API_BASE_URL}/step`);
    return response.data;
  },
};
