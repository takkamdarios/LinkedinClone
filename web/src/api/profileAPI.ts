import { baseURL } from "./baseURL";

const API_URL = baseURL+'/api/profiles'; 

const profileAPI = {
    getProfileById: async (id: string) => {
        try {
            const response = await fetch(`${API_URL}/${id}`);
            if (!response.ok) {
                throw new Error(`Failed to fetch profile with id ${id}`);
            }
            return await response.json(); 
        } catch (error) {
            console.error(`Error fetching profile with id ${id}:`, error);
            throw error; 
        }
    },

    updateProfile: async (id: string, profileData: { name: string; email: string; etc: string }) => {
        try {
            const response = await fetch(`${API_URL}/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(profileData)  
            });
            if (!response.ok) {
                throw new Error(`Failed to update profile with id ${id}`);
            }
            return await response.json();  
        } catch (error) {
            console.error(`Error updating profile with id ${id}:`, error);
            throw error;  
        }
    },

   
};

export default profileAPI;
