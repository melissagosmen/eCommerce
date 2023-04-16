export const getCategories = async () => {
    const response = await fetch("http://localhost:8080/categories").then(res => res.json())
    return response;
}