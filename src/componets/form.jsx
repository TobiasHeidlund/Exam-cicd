import React,{useState} from 'react'
import './form.css'
import axios from 'axios';

function form({typeOfAction, setResult}) {

    const [formData, setFormData] = useState({
        string: '',
        seed: '',
        encrypt: (typeOfAction=="Encrypt"),
      });
    const [submitted, setSubmitted] = useState(false);
    const apiUrl = import.meta.env.VITE_BACKENDURL;

    const onSubmit = (e)=>{
        e.preventDefault()
        console.log(formData)
        const jsonData = JSON.stringify(formData);
        console.log(jsonData)
        axios.post(apiUrl+"/"+typeOfAction,jsonData,{headers:{
            'Content-Type': 'application/json',
        }}).then((res)=>{
            if(res.status == 200){
                setSubmitted(true)
                e.target.reset()
                //DISPLAY HERE
                setFormData({...formData, string:'',seed:''})
                setResult(res.data["result"])
            }else{
                alert("Something went wrong please try again")
            }
        }).catch(error =>{
            console.log("Something went wrong")
            console.log(error)
        })

    }
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value // Update the specific field in state
        });
    };
  return (
    <form onSubmit={onSubmit}>
        <textarea type="text" placeholder={"String to " + typeOfAction} name='string' onChange={handleChange}/>
        <input type="text" placeholder='Encryption Seed' name='seed'  onChange={handleChange} />
        <input type="submit" />
    </form>
  )
}


export default form